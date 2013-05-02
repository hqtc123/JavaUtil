package interview;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-2
 * Time: 上午10:50
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个由n个整数组成的数组S，是否存在S中的三个数a,b,c使得 a+b+c=0?找出所有的不重复的和为0的三元组。
 * 注意：
 * 1.三元组的整数按照升序排列 a<b<c
 * 2.给出的结果中不能含有相同的三元组
 * <p/>
 * 分析：
 * 如果穷举所有这样的三元组，需要三重循环，算法的复杂度肯定是O(n3)。
 * 能不能把算法复杂度降到O(n2)呢？答案是可以的。
 * 首先我们要把数组排序(O(nlgn)),然后固定a,在剩余的数组中看能不能找到a+b+c=0
 * 因为数组是排序的，我们把b指向第一个元素，c指向末尾。
 * 三种情况：
 * a＋b＋c＝0：找到一组解
 * a＋b＋c<0: b向后移一位，增大和
 * a＋b＋c>0: c向前移一位，减小和
 * 还要注意的是去掉重复的解，保证a和b都和上次的不同即可。
 */
public class TriSumZero {
    public Set<ArrayList<Integer>> threeSumZero(int[] num) {
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        if (num == null || num.length < 3) {
            System.out.println("Invalis input nums");
            return null;
        }
        Arrays.sort(num);
        int len = num.length;
        for (int i = 0; i < len - 2; i++) {
            int a = num[i];
            int s = i + 1;
            int p = len - 1;
            while (s < p) {
                int b = num[s];
                int c = num[p];
                int sum = a + b + c;
                if (sum == 0) {
                    s++;
                    p--;
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(a);
                    item.add(b);
                    item.add(c);
                    result.add(item);
                } else if (sum < 0) {
                    s++;
                } else {
                    p--;
                }
            }
        }
        return result;
    }
}
