package interview;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-25
 * Time: 下午8:56
 * To change this template use File | Settings | File Templates.
 */
public class StringCompare {
    /**
     *  很简单，String对象被放进常量池里了，再次出现“java”字符串的时候，
     *  JVM很兴奋地把str2的引用也指向了 “java”对象，它认为自己节省了内存开销。不难理解吧 呵呵
     */
    public static void A() {
        String str1 = "java";
        String str2 = "java";
        System.out.println(str1 == str2);  //true
    }

    /**
     * 一旦看到new关键字，JVM会在堆中为String分配空间。
     */
    public static void B() {
        String str1 = new String("java");
        String str2 = new String("java");
        System.out.println(str1 == str2);  //false
    }

    /**
     * JVM确实会对型如String str1 = "java"; 的String对象放在字符串常量池里，但是它是在编译时刻那么做的
     * 而String s = str1+str2; 是在运行时刻才能知道（我们当然一眼就看穿了，可是Java必须在运行时才知道的，
     * 人脑和电脑的结构不同），也就是说str1+str2是在堆里创建的， s引用当然不可能指向字符串常量池里的对象
     */
    public static void C() {
        String str1 = "java";
        String str2 = "blog";
        String s = str1 + str2;
        System.out.println(s == "javablog");  //false
    }

    public static void C2() {
        String str1 = "javablog";
        String str2 = "java" + "blog";    //在编译时被优化成String str2 = "javablog";
        System.out.println(str1 == str2);  //true
    }

    public static void D() {
        String s1 = "java";
        String s2 = new String("java");
        System.out.println(s1.intern() == s2.intern());  //true
    }

    public static void E() {
        String str1 = "java";
        String str2 = new String("java");
        System.out.println(str1.equals(str2));  //true
    }

    public static void main(String[] args) {
        A();
        B();
        C();
        C2();
        D();
        E();
    }
}
