package sort;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-12
 * Time: 上午10:08
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {
    public void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int middle = (begin + end) / 2;
            mergeSort(arr, begin, middle);
            mergeSort(arr, middle+1, end);
            merge(arr, begin, middle, end);
        }
    }

    public void merge(int[] arr, int start, int middle, int end) {
        int leng1 = middle - start + 1;
        int leng2 = end - middle;

        int temA[] = new int[leng1 + 1];
        int temB[] = new int[leng2 + 1];

        for (int i = 0; i < leng1; i++) {
            temA[i] = arr[i + start - 1];
        }
        temA[leng1] = Integer.MAX_VALUE;
        for (int i = 0; i < leng2; i++) {
            temB[i] = arr[i + middle];
        }
        temB[leng2] = Integer.MAX_VALUE;

        int m = 0, n = 0;
        for (int i = start - 1; i < end; i++) {
            if (temA[m] > temB[n]) {
                arr[i] = temB[n];
                n++;
            } else {
                arr[i] = temA[m];
                m++;
            }
        }
    }
}
