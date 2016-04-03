package interview;

public class Main {

    public int getPartitionIndex(int[] arr, int left, int right) {
        int ele = arr[left];
        while (left < right) {
            while (arr[right] > ele && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] < ele && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = ele;
        return left;
    }

    public void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int index = getPartitionIndex(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        int i = 3;
        Integer j = new Integer(3);
        System.out.println(i == j);
        System.out.println(j == i);

        System.out.println(j.equals(i));
    }
}