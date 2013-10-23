package datastruture.sort;

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

    }

    public static void main(String args[]) {
        LinkedList aList = new LinkedList(new Node("e", null));
        aList.addNode(new Node("w", null));
        aList.addNode(new Node("q", null));
        aList.addNode(new Node("a", null));
        aList.print();
    }
}
