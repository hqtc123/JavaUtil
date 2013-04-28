package crawler;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-28
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler("http://www.blogjava.net", 100, "java");
        Thread searchThread = new Thread(crawler);
        searchThread.start();
    }
}
