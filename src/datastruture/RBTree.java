package datastruture;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-4-21
 * Time: 下午3:27
 * To change this template use File | Settings | File Templates.
 */
public class RBTree<T extends Comparable<T>> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    static class RBNode<T> {
        T data;
        RBNode parent, left, right;

        boolean color = BLACK;

        RBNode(T data, RBNode parent, RBNode left, RBNode right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "[data=" + this.data + ",color=" + this.color + "]";
        }
    }

    private RBNode<T> root;

    public RBTree() {
        this.root = null;
    }

    public RBTree(T t) {
        this.root = new RBNode(t, null, null, null);
    }

    public void add(T t) {
        if (this.root == null) {
            this.root = new RBNode(t, null, null, null);
        } else {
            RBNode<T> current = this.root;
            RBNode<T> parent = null;
            int cmp = 0;

            do {
                parent = current;
                cmp = t.compareTo(current.data);

                if (cmp > 0) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            } while (current != null);

            RBNode<T> newNode = new RBNode<T>(t, parent, null, null);

            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        }
    }
}
