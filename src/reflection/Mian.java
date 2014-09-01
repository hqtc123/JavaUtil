package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-10
 * Time: 下午9:36
 * To change this template use File | Settings | File Templates.
 */
public class Mian {
    public static void main(String[] args) {
        Demo de = new Demo();
        System.out.println(de.getClass().getName());

        /*
        实例化三个Class类的对象，，，Java中所有对象都是Class类的实例
         */
        Class<?> test = null;
        Class<?> test2 = null;
        Class<?> test3 = null;
        try {
            test = Class.forName("reflection.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        test2 = new Demo().getClass();
        test3 = Demo.class;

        assert test != null;
        System.out.println("类名：" + test.getName());
        System.out.println("类名：" + test2.getName());
        System.out.println("类名：" + test3.getName());

        /*
               通过Class类来调用Person的构造函数，创建对象
         */
        Class<?> test4 = null;
        try {
            test4=Class.forName("reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Person per1=null;
        Person per2=null;
        Constructor<?>[] cons=test4.getConstructors();        //通过Class对象取得Person的所有构造函数
        try {
            per1=(Person)cons[0].newInstance();
            per2=(Person)cons[1].newInstance(20,"贺庆");
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(per1);
        System.out.println(per2);
    }
}
