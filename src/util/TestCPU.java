package util;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-11
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
public class TestCPU {
    public static void main(String[] args) {
        for (; ; ) {
            for (int i = 0; i < 960000000; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

        }
    }
}
