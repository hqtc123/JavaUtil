package interview;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-26
 * Time: 下午8:42
 * To change this template use File | Settings | File Templates.
 */

/**
 * 题目如下：用1、2、2、3、4、5这六个数字，用java写一个main函数，
 * 打印出所有不同的排列，如：512234、412345等，要求："4"不能在第三位，
 * "3"与"5"不能相连。
 * 另一种用图实现 见datastructure包
 */
//神回复：
public class Tencent2013 {
    public static void main(String[] args) {
        for (int i = 122345; i <= 543221; i++) {
            String sb = String.valueOf(i);
            String temp = sb.replaceFirst("1", "a");
            temp = temp.replaceFirst("2", "a");
            temp = temp.replaceFirst("2", "a");
            temp = temp.replaceFirst("3", "a");
            temp = temp.replaceFirst("4", "a");
            temp = temp.replaceFirst("5", "a");
            if (!"aaaaaa".equals(temp)) {
                continue;
            }
            //排除4在第三位
            if (sb.indexOf("4") == 2)
                continue;
            //3 and 5 be together
            if (sb.indexOf("35") > -1 || sb.indexOf("53") > -1) {
                continue;
            }

            System.out.println(i);
        }
    }
}
