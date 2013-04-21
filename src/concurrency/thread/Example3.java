package concurrency.thread;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-7
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 * <p/>
 * Thread.interrupt()方法不会中断一个正在运行的线程。这一方法实际上完成的是，在线程受到阻塞时抛出
 * 一个中断信号，这样线程就得以退出阻塞的状态。更确切的说，如果线程被Object.wait, Thread.join和Thread.sleep
 * 三种方法之一阻塞，那么，Thread.interrupt()时它将接收到一个中断异常（InterruptedException），从而提早地终结被阻塞状态。
 *
 * 如果线程被上述几种方法阻塞，正确的停止线程方式是设置共享变量，并调用interrupt()（注意变量应该先设置）。
 * 如果线程没有被阻塞，这时调用interrupt()将不起作用；否则，线程就将得到异常（该线程必须事先预备好处理此状况），
 * 接着逃离阻塞状态。在任何一种情况中，最后线程都将检查共享变量然后再停止。
 */
public class Example3 extends Thread {
    volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Thread is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread be interrupted ..");
            }
        }

        System.out.println("Thread exit under request..");
    }

    public static void main(String[] args) {
        Example3 thread = new Example3();
        thread.setName("thread3");
        System.out.println("Thread is starting ..");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("Asking concurrency.thread to stop ..");
        thread.stop = true;  //如果线程处于阻塞状态，则不会检测到此变量的改变

        thread.interrupt();   //线程阻塞时才会起到作用

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("Application stopping ..");
        System.exit(0);
    }
}
