package reflection;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-10
 * Time: 下午9:36
 * To change this template use File | Settings | File Templates.
 */
public class Mian {
    public static void main(String[] args){
        Demo de=new Demo();
        System.out.println(de.getClass().getName());

        Class<?> test=null;
        Class<?> test2=null;
        Class<?> test3=null;
        try {
            test=Class.forName("reflection.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        test2=new Demo().getClass();
        test3=Demo.class;

        System.out.println("类名："+test.getName());
        System.out.println("类名："+test2.getName());
        System.out.println("类名："+test3.getName());
    }
}
