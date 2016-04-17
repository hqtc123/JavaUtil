package interview.micro;

import java.util.Scanner;

/**
 * Created by Qing on 2016/4/16.
 */
public class Trie {
    class TrieNode {
        int order = 0;
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    public void add(String binStr, int order, int mask) {
        TrieNode node = root;
        for (int i = 0; i < mask; i++) {
            if (node.order != 0) {
                return;
            }
            char a = binStr.charAt(i);
            int aInt = a - '0';
            if (node.children[aInt] == null) {
                node.children[aInt] = new TrieNode();
            }
            node = node.children[aInt];
        }
        if (node.order == 0) {
            node.order = order;
        }
    }

    public int find(String binStr) {
        TrieNode node = root;
        int order = 1;
        for (int i = 0; i < 32; i++) {
            if (node.order != 0) {
                order = node.order;
            }
            char a = binStr.charAt(i);
            int aInt = a - '0';
            if (node.children[aInt] == null) {
                break;
            }
            node = node.children[aInt];
        }
        return order;
    }

    public static String ip2BinStr(String ip) {
        String[] arr = ip.split("\\.");
        String rs = "";
        for (String str : arr) {
            String s = Integer.toBinaryString(Integer.parseInt(str));
            if (s.length() < 8) {
                int diff = 8 - s.length();
                for (int i = 0; i < diff; i++) {
                    s = "0" + s;
                }
            }
            rs += s;
        }
        return rs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trie trie = new Trie();
        String fLine = scanner.nextLine();
        int ruleNum = Integer.parseInt(fLine.split(" ")[0]);
        int ipNum = Integer.parseInt(fLine.split(" ")[1]);
        for (int i = 1; i <= ruleNum; i++) {
            int mask = 32;
            String line = scanner.nextLine();
            String[] lineArr = line.split(" ");
            int order = lineArr[0].equals("allow") ? i : -i;
            String ipRule = lineArr[1];
            if (ipRule.contains("/")) {
                String[] arr = ipRule.split("/");
                ipRule = arr[0];
                mask = Integer.parseInt(arr[1]);
            }
            trie.add(Trie.ip2BinStr(ipRule), order, mask);
        }
        for (int i = 0; i < ipNum; i++) {
            System.out.println(trie.find(Trie.ip2BinStr(scanner.nextLine())) < 0 ? "No" : "YES");
        }
    }
}

