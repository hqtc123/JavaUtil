package pattern.iterator;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public interface Aggregate<T,V,W> {
    public Iterator<T> createIteratorX();
    public Iterator<V> createIteratorY();
    public Iterator<W> createIteratorZ();
}
