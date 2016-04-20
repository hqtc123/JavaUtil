package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Qing on 2016/4/19.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int rs = 1;
        int m = n / 3;
        for (int i = 0; i < m - 1; i++) {
            rs *= 3;
        }
        if (n % 3 == 1)
            rs *= 4;
        if (n % 3 == 0) {
            rs *= 3;
        }
        if (n % 3 == 2) {
            rs *= 6;
        }
        return rs;
    }
    public static void main(String args[]){
        System.out.println(new IntegerBreak().integerBreak(10));
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2));
    }
}
