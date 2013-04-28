package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-27
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
public class WebCrawler implements Runnable {
    //disAllowListCache 缓存robots协议中不允许搜索的url
    //robots always be put at the website root directory
    //here is a robot.txt example
    /*
    #robots.txt for some.com
    User-agent:*;
    Disallow:/cgi-bin/
    Disallow:/login
     */

    private HashMap<String, ArrayList<String>> disAllowListCache
            = new HashMap<String, ArrayList<String>>();
    ArrayList<String> errorList = new ArrayList<String>();
    ArrayList<String> resultList = new ArrayList<String>();
    String startUrl;
    int macUrl;
    String searchString;    //English only
    boolean caseSensitive = false;      //大小写默认不敏感

    public WebCrawler(String startUrl, int macUrl, String searchString) {
        this.startUrl = startUrl;
        this.macUrl = macUrl;
        this.searchString = searchString;
    }

    public ArrayList<String> getResultList() {
        return resultList;
    }

    @Override
    public void run() {
        //todo
    }

    //check the url  format
    private URL verifyUrl(String url) {
        if (!url.toLowerCase().startsWith("http:")) {
            return null;
        }
        URL verifyUrl = null;
        try {
            verifyUrl = new URL(url);
        } catch (MalformedURLException e) {
            return null;
        }
        return verifyUrl;
    }

    //check if robots protocol allow
    private boolean isRobotAllowed(URL urlToCheck) {
        String host = urlToCheck.getHost().toLowerCase();

        ArrayList<String> disAllowList = disAllowListCache.get(host);

        if (disAllowList == null) {
            disAllowList = new ArrayList<String>();
            try {
                URL robotPath = new URL("http://" + host + "/robots.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(robotPath.openStream()));
                //get disallow list from robots.txt
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.indexOf("Disallow:") > -1) {
                        String disallowPath = line.substring("Disallow:".length());
                        //check if note(注释) exists
                        int noteIndex = disallowPath.indexOf("#");
                        if (noteIndex > -1) {
                            disallowPath = disallowPath.substring(0, noteIndex);
                        }
                        disallowPath = disallowPath.trim();
                        disAllowList.add(disallowPath);
                    }
                }
                disAllowListCache.put(host, disAllowList);  // put the disallow path of this host in cache
            } catch (MalformedURLException e) {
                return true;  //robots.txt not found, means allowed
            } catch (IOException e) {
                return true;      //robots file open failed , means allowed
            }
        }
        String file = urlToCheck.getFile();
        for (int i = 0; i < disAllowList.size(); i++) {
            String disallowPath = disAllowList.get(i);
            if (file.startsWith(disallowPath)) {
                return false;
            }
        }
        return true;
    }

    private String downloadPage(URL pageUrl) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pageUrl.openStream()));
            //read page into buffer
            String line;
            StringBuffer pageBuffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                pageBuffer.append(line);
            }
            return pageBuffer.toString();
        } catch (IOException e) {
        }
        return null;
    }

    //remove "www" from url
    private String removeWWW(String url) {
        int index = url.indexOf("://www.");
        if (index > -1) {
            return url.substring(0, index + 3) + url.substring(index + 7);
        }
        return url;
    }

    //analyze the page and find the links
    private ArrayList<String> retrieveLinks(URL pageUrl, String pageContents, HashSet<String> crawlList,
                                            boolean limitHost) {
        Pattern p = Pattern.compile("<a\\s+href\\s*=\\s*\"?(.*?)[\"|>]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(pageContents);
        ArrayList<String> linkList = new ArrayList<String>();
        while (m.find()) {
            String link = m.group(1).trim();
            if (link.length() < 1) {
                continue;
            }
            //skip the link points to the page itself
            if (link.charAt(0) == '#') {
                continue;
            }
            if (link.indexOf("mailto:") > -1) {
                continue;
            }
            if (link.toLowerCase().indexOf("javascript") > -1) {
                continue;
            }

            if (link.indexOf("://") == -1) {
                if (link.charAt(0) == '/') {
                    //deal the absolute path
                    link = "http://" + pageUrl.getHost() + ":" + pageUrl.getPort() + "/" + link;
                } else {
                    String file = pageUrl.getFile();
                    if (file.indexOf("/") == -1) {
                        link = "http://" + pageUrl.getHost() + ":" + pageUrl.getPath() + "/" + link;
                    } else {
                        String path = file.substring(0, file.indexOf("/") + 1);
                        link = "http://" + pageUrl.getHost() + ":" + pageUrl.getPath() + path + link;
                    }
                }
            }
            int index = link.indexOf("#");
            if (index > -1) {
                link = link.substring(0, index);
            }

            link = removeWWW(link);

            URL verifiedUrl = verifyUrl(link);
            if (verifiedUrl == null) {
                continue;
            }
            // limit the host, abandon the urls not satisfy require
            if (limitHost && !pageUrl.getHost().toLowerCase().equals(verifiedUrl.getHost().toLowerCase())) {
                continue;
            }
            if (crawlList.contains(link)) {
                continue;
            }
            linkList.add(link);
        }
        return linkList;
    }

    //search the download page , find if there exits the string
    private boolean searchStringMatches(String pageCotents, String str,
                                        boolean caseSensitive) {
        String searchContents = pageCotents;
        if (!caseSensitive) {
            searchContents = pageCotents.toLowerCase();
        }

        Pattern p = Pattern.compile("[\\s]+");
        String[] terms = p.split(str);
        for (int i = 0; i < terms.length; i++) {
            if (caseSensitive) {
                if (searchContents.indexOf(terms[i]) == -1) {
                    return false;
                }
            } else {
                if (searchContents.indexOf(terms[i].toLowerCase()) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    // the main search method
    public ArrayList<String> crawl(String startUrl, int maxUrls, String searchString,
                                   boolean limitHos, boolean caseSensitive) {
        System.out.println("searchString:" + searchString);
        HashSet<String> crawlList = new HashSet<String>();
        LinkedHashSet<String> toCrawlList = new LinkedHashSet<String>();

        if (maxUrls < 1) {
            errorList.add("Invalid max urls value :");
        }

        if (searchString.length() < 1) {
            errorList.add("No valid search string.");
        }
        if (errorList.size() > 0) {
            System.out.println("Error occurs:  ");
            return errorList;
        }

        startUrl = removeWWW(startUrl);

        toCrawlList.add(startUrl);
        while (toCrawlList.size() > 0) {
            if (maxUrls != -1) {
                if (crawlList.size() == maxUrls) {
                    break;
                }
            }

            String url = toCrawlList.iterator().next();
            toCrawlList.remove(url);
            URL verifiedUrl = verifyUrl(url);

            if (!isRobotAllowed(verifiedUrl)) {
                continue;
            }

            crawlList.add(url);
            String pageContents = downloadPage(verifiedUrl);

            if (pageContents != null && pageContents.length() > 0) {
                ArrayList<String> links = retrieveLinks(verifiedUrl,
                        pageContents, crawlList, limitHos);
                toCrawlList.addAll(links);

                if (searchStringMatches(pageContents, searchString, caseSensitive)) {
                    resultList.add(url);
                    System.out.println(url);
                }
            }
        }
        return resultList;
    }
}
