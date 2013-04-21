package concurrency.thread.produceandconsumer;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-11
 * Time: 上午11:23
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Info info = new Info();
        Producer producer = new Producer(info);
        Consumer consumer = new Consumer(info);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
