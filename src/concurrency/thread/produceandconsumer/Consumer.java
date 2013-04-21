package concurrency.thread.produceandconsumer;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-11
 * Time: 上午11:18
 * To change this template use File | Settings | File Templates.
 */

/**
 * Consumer use the two info
 */
public class Consumer implements Runnable {
    private Info info;

    public Consumer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println(this.info.get());
        }
    }
}
