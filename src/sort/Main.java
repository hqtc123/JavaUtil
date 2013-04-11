package sort;

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

//        InsertionSort sort = new InsertionSort();
//        sort.sort(nums);

        BubbleSort sort1=new BubbleSort();
        sort1.sort(nums);
        PrintArr.printIntArr(nums);

    }
}
