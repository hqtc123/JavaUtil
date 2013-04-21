package concurrency.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-9
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */
public class TaskExecutionWebServer {
    private static final int THREADNUM = 100;
    private static final Executor exec = Executors.newFixedThreadPool(THREADNUM);

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(80);

            while (true) {
                final Socket conn = socket.accept();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        //handle connection   conn
                    }
                };
                exec.execute(task);
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
