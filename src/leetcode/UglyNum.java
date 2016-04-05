package leetcode;

/**
 * Created by Qing on 2016/4/5.
 */
public class UglyNum {
    public int min(int a, int b, int c) {
        int min = a > b ? b : a;
        return min > c ? c : min;
    }

    public int nthUglyNum(int n) {
        if (n == 1)
            return 1;
        int factor1 = 2, factor2 = 3, factor3 = 5;
        int min = 1;
        for (int i = 2; i <= n; i++) {
            min = min(factor1, factor2, factor3);
            if (min == factor1)
                factor1 = factor1 * 2;
            if (min == factor2)
                factor2 = factor2 * 3;
            if (min == factor3)
                factor3 = factor3 * 5;
        }
        return min;
    }
}
