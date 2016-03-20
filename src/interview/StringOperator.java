package interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Qing on 2016/3/18.
 */
public class StringOperator {


    public String reverse(String s) {
        StringBuilder builder = new StringBuilder(s);
        builder = builder.reverse();
        return builder.toString();
    }

    public String moveToTail(String s, int n) {
        String s1 = this.reverse(s.substring(0, n));
        String s2 = this.reverse(s.substring(n));
        return this.reverse(s1 + s2);
    }

    public List<Integer> lcs(List<Integer> a, List<Integer> b) {
        List<Integer> rsList = new LinkedList<>();
        int sizeA = a.size(), sizeB = b.size();
        if (sizeA == 0 || sizeB == 0) {
            return rsList;
        }
        if (a.get(sizeA - 1).equals(b.get(sizeB - 1))) {
            int m = a.get(sizeA - 1);
            List<Integer> subList = lcs(a.subList(0, sizeA - 1), b.subList(0, sizeB - 1));
            subList.add(m);
            return subList;
        }
        List<Integer> sub1 = lcs(a.subList(0, sizeA - 1), b);
        List<Integer> sub2 = lcs(a, b.subList(0, sizeB - 1));
        return sub1.size() > sub2.size() ? sub1 : sub2;
    }

    public static void main(String[] args) {
        StringOperator operator = new StringOperator();
        String s = "Hello World";
        System.out.println(operator.moveToTail(s, 2));
        System.out.println(s.hashCode());

        System.out.println(operator.lcs(Arrays.asList(1, 2, 4, 6, 9, 3),Arrays.asList(1,4,3,9,6)));
    }
}
