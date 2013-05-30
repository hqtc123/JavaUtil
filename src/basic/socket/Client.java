package basic.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-30
 * Time: 下午7:38
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    private Socket s;
    public Client(){
        try {
            this.s=new Socket("127.0.0.1",9001);
            this.s.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
