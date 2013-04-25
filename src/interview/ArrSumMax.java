package interview;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-25
 * Time: 下午9:33
 * To change this template use File | Settings | File Templates.
 */

/**
 * 输入一个整形数组，数组里有正数也有负数。
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
 * 因此输出为该子数组的和18。
 * ANSWER:
 * A traditional greedy approach.
 * Keep current sum, slide from left to right, when sum < 0, reset sum to 0.
 */
public class ArrSumMax {
    public int maxSum(int a[]) {
        int sum = 0;
        int max = -(1 << 31);
        int current = 0;
        while (current < a.length) {
            sum += a[current];
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                sum = 0;
            }
            current++;
        }
        return max;
    }
}
