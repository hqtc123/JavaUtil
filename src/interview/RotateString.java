package interview;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-22
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */

/**
 * 把字符串前面的若干个字符移动到字符串的尾部。
 * 如把字符串abcdef前2位字符移到后面得到字符串cdefab。
 * 要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)。
 */
public class RotateString {
    public static void rotate(char[] arr, int begin, int end) {
        while (begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }

    public static String rotateString(String a, int num) {
        char[] arr = a.toCharArray();
        rotate(arr, 0, num - 1);
        rotate(arr, num, arr.length - 1);
        rotate(arr, 0, arr.length - 1);
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "sklfjh;aofv";
        System.out.println(RotateString.rotateString(str, 2));
    }
}
