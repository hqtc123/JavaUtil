package concurrency.thread.produceandconsumer;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-11
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */

/**
 * Producer produce two kinds  of info
 */
public class Producer implements Runnable {
    private Info info;

    public Producer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        boolean flag = false;
        for (int i = 0; i < 25; i++) {
            if (flag) {
                this.info.set("He",20);
                flag = false;
            } else {
                this.info.set("Qing",21);
                flag = true;
            }
        }
    }
}
