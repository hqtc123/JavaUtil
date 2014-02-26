package datastruture.sort;

import util.PrintArr;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-10
 * Time: 上午11:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 6, 26, 78, 3, 2, 45, 21};

//        InsertionSort datastruture.sort = new InsertionSort();
//        datastruture.sort.datastruture.sort(nums);

//        BubbleSort sort1=new BubbleSort();
//        sort1.datastruture.sort(nums);

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length-1);

        PrintArr.printIntArr(nums);

    }
}
