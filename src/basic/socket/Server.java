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
    private ServerSocket serSocket;
    public Server(int port){
        try {
            serSocket=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public void start(){
        while (true){
            try {
                Socket socket=serSocket.accept();
                System.out.println(socket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
    public static void main(String[] args){
        new Server(8090).start();
        new Client();
    }
}
