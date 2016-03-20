package datastruture;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: heqing02
 * Date: 13-10-23
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
public class LinkedList {
    public static class Node {

        public Node(String value, Node next) {
            this.next = next;
            this.value = value;
        }

        Node next;
        String value;
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    Node head;

    public void addNode(Node head, Node toAdd) {
        if (head == null) {
            head = toAdd;
            return;
        }
        if (head.next == null) {
            head.next = toAdd;
            return;
        }
        addNode(head.next, toAdd);
    }

    public void addNode(Node toAdd) {
        addNode(this.head, toAdd);
    }

    public void print() {
        if (head == null) {
            System.out.println("empty list");
            return;
        }
        if (head.next == null) {
            System.out.print(head.value + "  > ");
            return;
        }
        System.out.print(head.value + "  > ");
        new LinkedList(head.next).print();
    }

    public void reverse() {
        if (head == null || head.next == null) return;
        Node aNode = head;
        Node prev = null;
        Node next = head.next;
        while (next != null) {
            aNode.next = prev;
            prev = aNode;
            aNode = next;
            next = next.next;
        }
        aNode.next = prev;
        head=aNode;
    }

    public static class A{}

    public static void main(String args[]) {
        LinkedList aList = new LinkedList(new Node("0", null));
        aList.addNode(new Node("a", null));
        aList.addNode(new Node("b", null));
        aList.addNode(new Node("c", null));
        aList.print();
        System.out.println("");
        aList.reverse();
        aList.print();

        Node a = new Node("0",null);
        Node b = new Node("0",null);
        System.out.println();
        System.out.println(a.equals(b));
        A a1 = new A();
        A a2 = new A();
        System.out.println(a1.equals(a2));
        ArrayList la = new ArrayList();
        ArrayList lb = new ArrayList();
        System.out.println(la.equals(lb));
    }
}
