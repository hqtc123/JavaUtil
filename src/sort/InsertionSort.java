package sort;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-10
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort {
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            int j = i;
            while ((j > 0) && (nums[j - 1] > t)) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = t;
        }
    }
}
