package datastruture.sort;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-22
 * Time: 下午9:52
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort implements Sort {
    private int getSeparatorIndex(int[] nums, int low, int high) {
        int k = nums[low];
        while (low < high) {
            while (k < nums[high] && low < high) {
                high--;
            }
            if (low < high)
                nums[low++] = nums[high];
            while (k > nums[low] && low < high) {
                low++;
            }
            if (low < high)
                nums[high--] = nums[low];
        }
        nums[low] = k;
        return low;
    }

    public void sort(int num[], int low, int high) {
        if (low < high) {
            int sepIndex = getSeparatorIndex(num, low, high);
            sort(num, low, sepIndex - 1);
            sort(num, sepIndex + 1, high);
        }
    }

    public int findKthMax(int arr[], int k, int left, int right) {
        int sepIndex = getSeparatorIndex(arr, left, right);
        if (k == arr.length - sepIndex) {
            return arr[sepIndex];
        } else {
            if (k > arr.length - sepIndex) {
                return findKthMax(arr, k, left, sepIndex - 1);
            } else {
                return findKthMax(arr, k, sepIndex + 1, right);
            }
        }
    }

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
}
