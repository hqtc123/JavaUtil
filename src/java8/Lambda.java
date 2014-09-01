package java8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by simu-hq on 2014/8/30.
 */
public class Lambda {

    public int compareStr(String lhs, String rhs) {
        return lhs.compareTo(rhs);
    }

    public static void printStrArr(String[] arr) {
        for (String i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println("=====================");
    }

    public static void main(String args[]) {
        StringBuilder builder = new StringBuilder();

        //Runnable is a functional interface
        //Only has one abstract method
        Runnable r = () -> System.out.println(builder.toString());
        builder.append("hello");
        r.run();   // got "hello";
        builder.append(" world");
        r.run();   // got "hello world";
        System.out.println("==================");


        String[] strings = new String[]{"good", "bad", "so", "do", "serious"};
        Lambda lambda = new Lambda();
        //1. Arrays.sort(T[] t, Comparator<T> comparator>
        Comparator<String> cr = lambda::compareStr;
        Arrays.sort(strings, cr);
        Lambda.printStrArr(strings);

        // 2.directly use function for
        Arrays.sort(strings, lambda::compareStr);
        Lambda.printStrArr(strings);
        // 3. define function for comparator
        Arrays.sort(strings, (lhs, rhs) -> lhs.compareTo(rhs));
        Lambda.printStrArr(strings);
    }
}
