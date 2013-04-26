package datastruture;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-26
 * Time: 下午8:42
 * To change this template use File | Settings | File Templates.
 */

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 题目如下：用1、2、2、3、4、5这六个数字，用java写一个main函数，
 * 打印出所有不同的排列，如：512234、412345等，要求："4"不能在第三位，
 * "3"与"5"不能相连。
 * <p/>
 * 1 把问题归结为图结构的遍历问题。实际上6个数字就是六个结点，把六个结点连接成无向连通图，对于每一个结点求这个图形的遍历路径，所有结点的遍历路径就是最后对这6个数字的排列组合结果集。
 * 2 显然这个结果集还未达到题目的要求。从以下几个方面考虑：
 * 1. 3，5不能相连：实际要求这个连通图的结点3，5之间不能连通, 可在构造图结构时就满足改条件，然后再遍历图。
 * 2. 不能有重复: 考虑到有两个2，明显会存在重复结果，可以把结果集放在TreeSet中过滤重复结果
 * 3. 4不能在第三位: 仍旧在结果集中去除满足此条件的结果。
 */
public class Tencent2013 {
    private String[] b = new String[]{"1", "2", "2", "3", "4", "5"};
    private int n = b.length;
    private boolean[] visited = new boolean[n];
    private int[][] a = new int[n][n];
    private String result = "";
    private TreeSet<String> set = new TreeSet<String>();

    public static void main(String[] args) {
        new Tencent2013().run();
    }

    private void run() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }
        // 3 is the 4th num, 5 is the 6th num. can not be neighbor
        a[3][5] = 0;
        a[5][3] = 0;

        for (int i = 0; i < n; i++) {
            depthFirstSearch(i);
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.indexOf("4") != 2) {
                System.out.println(str);
            }
        }
    }

    //iterator  graph
    private void depthFirstSearch(int i) {
        visited[i] = true;
        result += b[i];
        if (result.length() == n) {
            set.add(result);
        }
        for (int j = 0; j < n; j++) {
            if (a[i][j] == 1 && visited[j] == false) {
                depthFirstSearch(j);
            } else {
                continue;
            }
        }
        result = result.substring(0, result.length() - 1);
        visited[i] = false;
    }
}
