package pattern.proxy;

/**
 * Created by Qing on 2016/4/5.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello " + name);
    }
}
