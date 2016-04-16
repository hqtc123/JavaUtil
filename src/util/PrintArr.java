package util;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-10
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
public class PrintArr {
    public static void printIntArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printIntArr(String[] arr) {
        for (String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
