package interview;

import util.PrintArr;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-20
 * Time: 下午7:22
 * To change this template use File | Settings | File Templates.
 */

/**
 * 给定一个数组a[N],我们希望构造数组b[N]，其中b[i]=a[0]*a[1]*...*a[N-1]/a[i]。在构造过程：
 * 不允许使用除法；
 * 要求O(1)空间复杂度和O(n)时间复杂度；
 * 除遍历计数器与a[N] b[N]外，不可使用新的变量(包括栈临时变量、对空间和全局静态变量等)；
 */
public class tencent2012 {
    public static void main(String args[]) {
        final int N = 4;
        int a[] = {1, 2, 3, 4};
        int b[] = new int[N];
        b[N - 1] = a[N - 1];
        for (int i = N - 2; i > 0; i--) {
            b[i] = b[i + 1] * a[i];
        }
        b[0] = b[1];
        for (int i = 1; i < N; i++) {
            a[i] *= a[i - 1];
        }
        PrintArr.printIntArr(a);
        PrintArr.printIntArr(b);
        for (int i = 1; i < N; i++) {
            if (i == N - 1) {
                b[i] = a[i - 1];
            } else {
                b[i] = a[i - 1] * b[i + 1];
            }
        }
        PrintArr.printIntArr(b);
    }
}
