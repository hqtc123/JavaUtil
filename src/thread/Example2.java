package thread;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-7
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 * 中断线程最好的，最受推荐的方式是，使用共享变量（shared variable）发出信号，
 * 告诉线程必须停止正在运行的任务。线程必须周期性的核查这一变量（尤其在冗余操作期间），然后有秩序地中止任务。
 */
public class Example2 extends Thread {
    volatile boolean stop = false;

    public Example2(String name){
        super(name);
    }

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Thread is running .......");
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time < 1000 && (!stop))) {  //周期性检查

            }
        }

        System.out.println("Thread stopped under request .");
    }

    public static void main(String[] args) {
        Example2 thread=new Example2("thread2");
        System.out.println("Thread starting ....");
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Asking thread to stop ....");

        thread.stop=true;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        System.out.println("stop application !!");
        System.exit(0);
    }
}
