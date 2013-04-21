package pattern.iterator;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        Aggregate<Integer, Integer, Integer> ag = new DataList<Integer, Integer, Integer>();
        ((DataList) ag).add(new ThreeD<Integer, Integer, Integer>(1, 2, 3));
        ((DataList) ag).add(new ThreeD<Integer, Integer, Integer>(1, 2, 3));
        ((DataList) ag).add(new ThreeD<Integer, Integer, Integer>(1, 2, 3));
        Iterator<Integer> ia = ag.createIteratorX();
        while (ia.next() != null) {
            System.out.println(ia.currentItem());
        }
        Iterator<Integer> ib = ag.createIteratorY();
        while (ib.next() != null) {
            System.out.println(ib.currentItem());
        }
        Iterator<Integer> ic = ag.createIteratorZ();
        while (ic.next() != null) {
            System.out.println(ic.currentItem());
        }
    }
}
