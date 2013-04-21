package pattern.iterator;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */
public interface Iterator<T>{
    public T first();
    public T next();
    public boolean isDone();
    public T currentItem();
}
