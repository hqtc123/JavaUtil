package basic.yuanjing;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-30
 * Time: 下午7:29
 * To change this template use File | Settings | File Templates.
 */
public class TestArray {
    public static void foo(Integer i){
        System.out.println("Integer");
    }
    public static void foo(short i){
        System.out.println("short");
    }
    public static void main(String[] args) {
        int a[] = new int[15];
        Object o = new int[12];
        //int a[][]={1,2,3},{2,3,3};    error
        foo(10);
    }
}
