package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

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
}
