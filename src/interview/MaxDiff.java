package interview;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-2
 * Time: 上午11:44
 * To change this template use File | Settings | File Templates.
 */

/**
 * 题目：在数组中，数字减去它右边的数字得到一个数对之差。求所有数对之差的最大值。
 * 例如在数组{2, 4, 1, 16, 7, 5, 11, 9}中，数对之差的最大值是11，是16减去5的结果。
 * <p/>
 * 分析：从后往前遍历，记录最大差值
 */
public class MaxDiff {
    public int solve(int[] arr) {
        int len = arr.length;
        int ans = 0, min_v = arr[len - 1];
        for (int i = len - 2; i >= 0; i++) {
            if (arr[i] - min_v > ans) {
                ans = arr[i] - min_v;
            }
            if (arr[i] < min_v) {
                min_v = arr[i];
            }
        }
        return ans;
    }
}
