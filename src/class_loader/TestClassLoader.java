package class_loader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Qing on 2016/4/9.
 */
public class TestClassLoader {
    public static void main(String[] args) throws Exception {
        String url = "file://" + System.getProperty("user.dir").replaceAll("\\\\", "/")
                + "/out/production/JavaUtil/";
        System.out.println(url);
        ClassLoader c1 = new URLClassLoader(new URL[]{new URL(url)}, null);
        System.out.println("c1的父类加载器: " + c1.getParent());
        System.out.println("SystemClassLoader: " + ClassLoader.getSystemClassLoader());
        Class<?> class1 = c1.loadClass("class_loader.Person");
        Object o = class1.newInstance();
        System.out.println("Person:" + o);
        System.out.println("Test的定义类装载器: " + TestClassLoader.class.getClassLoader());
        System.out.println("Test中直接使用Person使用的ClassLoader: " + Person.class.getClassLoader());
        System.out.println("自定义装载器装载Person的定义类加载器: " + o.getClass().getClassLoader());

        Person p = (Person) o;
    }
}

