package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Qing on 2016/4/19.
 */

//* Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class LevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rs = new LinkedList<>();
        List<TreeNode> list = Arrays.asList(root);
        while (list.size() != 0) {
            List<Integer> intList = new ArrayList<>();
            for (TreeNode node : list) {
                intList.add(node.val);
            }
            rs.add(0, intList);
            List<TreeNode> list2 = new LinkedList<>();
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                if (node.left != null) {
                    list2.add(node.left);
                }
                if (node.right != null) {
                    list2.add(node.right);
                }
            }
            list = list2;
        }
        return rs;
    }
}
