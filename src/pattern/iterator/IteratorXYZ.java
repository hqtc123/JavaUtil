package pattern.iterator;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public abstract class IteratorXYZ<T> implements Iterator<T> {
    protected DataList ag;
    protected int i;

    public IteratorXYZ(DataList ag) {
        this.ag = ag;
        this.i = -1;
    }

    @Override
    public T first() {
        i = 0;
        return currentItem();
    }

    @Override
    public T next() {
        i += 1;
        return currentItem();
    }

    @Override
    public boolean isDone() {
        return i >= ag.size();
    }

    @Override
    public abstract T currentItem();
}
