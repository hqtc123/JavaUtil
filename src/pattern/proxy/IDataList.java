package pattern.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
public interface IDataList<T, V, W> {
    public T getX(int index) throws Exception;

    public V getY(int index) throws Exception;

    public W getZ(int index) throws Exception;

    public int size();
}
