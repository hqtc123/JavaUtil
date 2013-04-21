package pattern.iterator;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
public class DataList<T, V, W> implements Aggregate<T, V, W> {
    private ArrayList<ThreeD<T, V, W>> list = new ArrayList<ThreeD<T, V, W>>();
    private IteratorX<T> ix = new IteratorX<T>(this);
    private IteratorY<V> iy = new IteratorY<V>(this);
    private IteratorZ<W> iz = new IteratorZ<W>(this);

    public int size() {
        return list.size();
    }

    public void add(ThreeD<T, V, W> t) {
        list.add(t);
    }

    public ThreeD<T, V, W> get(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<T> createIteratorX() {
        return ix;
    }

    @Override
    public Iterator<V> createIteratorY() {
        return iy;
    }

    @Override
    public Iterator<W> createIteratorZ() {
        return iz;
    }
}
