package datastruture.sort;

import util.PrintArr;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-10
 * Time: 上午11:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static final long LONG_MASK = 0xffffffffL;

    public static int[] add(int[] x, int[] y) {
        // If x is shorter, swap the two arrays
        if (x.length < y.length) {
            int[] tmp = x;
            x = y;
            y = tmp;
        }
        int xIndex = x.length;
        int yIndex = y.length;
        //保存结果，一个与较长数组一样长的数组
        //为什么不是数组长度 +1， 因为如果加到最后result[0]里面可以是一个两位数~
        int result[] = new int[xIndex];
        long sum = 0;
        if (yIndex == 1) {
            //如果y的位数是1，则直接将sum保存在最后一位
            //例如 [9][9][9]+[8]，则sum就是17；而result就是[][][17]
            sum = (x[--xIndex] & LONG_MASK) + (y[0] & LONG_MASK);
            result[xIndex] = (int) sum;
        } else {
            // Add common parts of both numbers
            while (yIndex > 0) {
                sum = (x[--xIndex] & LONG_MASK) +
                        (y[--yIndex] & LONG_MASK) + (sum >>> 32);
                result[xIndex] = (int) sum;
            }
        }
        // Copy remainder of longer number while carry propagation is required
        boolean carry = (sum >>> 32 != 0);
        while (xIndex > 0 && carry)
            carry = ((result[--xIndex] = x[xIndex] + 1) == 0);
        // Copy remainder of longer number
        while (xIndex > 0)
            result[--xIndex] = x[xIndex];
        // Grow result if necessary
        if (carry) {
            int bigger[] = new int[result.length + 1];
            System.arraycopy(result, 0, bigger, 1, result.length);
            bigger[0] = 0x01;
            return bigger;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 21, 6, 26, 78, 3, 2, 45, 21};

//        InsertionSort datastruture.sort = new InsertionSort();
//        datastruture.sort.datastruture.sort(nums);

//        BubbleSort sort1=new BubbleSort();
//        sort1.datastruture.sort(nums);

//        MergeSort mergeSort = new MergeSort();
//        mergeSort.mergeSort(nums, 0, nums.length - 1);

//        PrintArr.printIntArr(nums);
//
//        QuickSort quickSort = new QuickSort();
//        quickSort.sort(nums);
//        PrintArr.printIntArr(nums);

//        BigInteger it = new BigInteger("000");
//        System.out.println(quickSort.findKthMax(nums,6,0,nums.length-1));

//        int a = 5;
//        long MASK = 0xffffffffL;
//        int b = 16;
//        long a1 = a & MASK;
//        long b1 = b & MASK;
//        long sum = a1+b1;
//        System.out.println(sum);
//        System.out.println(sum>>>32);
//
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Long.MIN_VALUE);
//        System.out.println((long)(Math.pow(2,63)));

        int a[] = new int[]{12349, 888, 5};
        int b[] = new int[]{99999, 888, 5};
        int c[] = Main.add(a, b);
        PrintArr.printIntArr(c);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println((long)Math.pow(2,31));

        int s = '0';
        System.out.println(s);
    }
}
