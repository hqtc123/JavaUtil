package datastruture;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Qing on 2016/4/14.
 */
public class BinaryTree {
    TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void recursivePre(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val);
        if (node.left != null) {
            recursivePre(node.left);
        }
        if (node.right != null) {
            recursivePre(node.right);
        }
    }

    public void nonRecursivePre(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(node);
        while (!nodeStack.empty()) {
            TreeNode peek = nodeStack.pop();
            System.out.print(peek.val);
            if (peek.right != null) {
                nodeStack.push(peek.right);
            }
            if (peek.left != null) {
                nodeStack.push(peek.left);
            }
        }
    }

    public void nonRecursiveMiddle(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> nodeStack = new Stack<>();
            while (node != null || !nodeStack.empty()) {
                while (node != null) {
                    nodeStack.push(node);
                    node = node.left;
                }
                node = nodeStack.pop();
                System.out.print(node.val);
                node = node.right;
            }
        }
    }

    public void nonRecursiveAfter(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> nodeStack = new Stack<>();
            TreeNode pre = null;
            while (node != null || !nodeStack.empty()) {
                while (node != null) {
                    nodeStack.push(node);
                    node = node.left;
                }
                node = nodeStack.peek();
                if (node.right == null || node.right.equals(pre)) {
                    System.out.print(node.val);
                    pre = node;
                    nodeStack.pop();
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
    }

    public void layer(TreeNode node) {
        if (node != null) {
            java.util.LinkedList<TreeNode> nodeList = new LinkedList<>();
            nodeList.add(node);
            while (!nodeList.isEmpty()) {
                TreeNode head = nodeList.get(0);
                if (head.left != null) {
                    nodeList.add(head.left);
                }
                if (head.right != null) {
                    nodeList.add(head.right);
                }
                System.out.print(head.val);
                nodeList.remove(0);
            }
        }
    }

    /**
     * '    5
     * '  3   4
     * ' 1 2 6
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode a = new TreeNode();
        a.val = 1;
        TreeNode b = new TreeNode();
        b.val = 2;
        TreeNode c = new TreeNode();
        c.val = 3;
        c.left = a;
        c.right = b;
        TreeNode f = new TreeNode();
        f.val = 6;
        TreeNode d = new TreeNode();
        d.val = 4;
        d.left = f;
        TreeNode e = new TreeNode();
        e.val = 5;
        e.left = c;
        e.right = d;
        BinaryTree tree = new BinaryTree(e);
        tree.recursivePre(e);
        System.out.println();
        tree.nonRecursivePre(e);
        System.out.println();
        tree.nonRecursiveMiddle(e);
        System.out.println();
        tree.nonRecursiveAfter(e);
        System.out.println();
        tree.layer(e);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}