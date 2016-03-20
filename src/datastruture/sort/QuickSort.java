package datastruture.sort;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-22
 * Time: 下午9:52
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort implements Sort {
    private int getMiddle(int[] nums, int low, int high) {
        int k = nums[low];
        while (low < high) {
            while (k < nums[high] && low < high) {
                high--;
            }
            nums[low] = nums[high];
            while (k > nums[low] && low < high) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = k;
        return low;
    }

    public void sort(int num[], int low, int high) {
        if (low < high) {
            int middle = getMiddle(num, low, high);
            sort(num, low, middle - 1);
            sort(num, middle + 1, high);
        }
    }

    public void sort(int nums[]) {
        sort(nums, 0, nums.length - 1);
    }
}
