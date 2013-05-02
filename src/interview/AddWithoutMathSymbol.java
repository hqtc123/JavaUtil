package interview;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-2
 * Time: 下午7:28
 * To change this template use File | Settings | File Templates.
 */

/**
 * 写一个函数，求两个整数的之和，要求在函数体内不得使用＋、－、×、/。
 * <p/>
 * 分析
 * 对数字做运算，除了四则运算之外，也就只剩下位运算了。
 */
public class AddWithoutMathSymbol {
    public int bitAdd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return bitAdd(sum, carry);
    }

    public static void main(String args[]) {
        System.out.println(new AddWithoutMathSymbol().bitAdd(-4, 246));
    }
}
