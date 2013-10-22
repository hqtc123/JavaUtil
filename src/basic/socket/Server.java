package basic.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-30
 * Time: 下午7:36
 * To change this template use File | Settings | File Templates.
 */
public class Server {
    /**
     * ServerSocket 创建时候需要一个port参数
     * 通过无限循环while（true） ；执行accept()返回一个socket与链接的客户端socket通信
     */
    private ServerSocket serSocket;

    public Server(int port) {
        try {
            serSocket = new ServerSocket(port);
            System.out.println("waiting......");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void start() {
        try {
            Socket socket = serSocket.accept();
            System.out.println("accept..");
            System.out.println(socket.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void main(String[] args) {
        new Server(8090).start();
        new Client();
    }
}
