package pattern.proxy;

/**
 * Created by Qing on 2016/4/5.
 */
public class Main {
    public static void main(String[] args){
        CGLibProxy cgLibProxy = new CGLibProxy();
        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);
        helloProxy.say("captain");
        Object obj = new Object();
    }
}
