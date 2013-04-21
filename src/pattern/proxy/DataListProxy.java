package pattern.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
public abstract class DataListProxy<T, V, W> implements IDataList<T, V, W> {
    protected IDataList<T, V, W> real;

    protected DataListProxy(IDataList<T, V, W> real) {
        this.real = real;
    }

    @Override
    public T getX(int index) throws Exception {
        return null;  //todo
    }

    @Override
    public V getY(int index) throws Exception {
        return null;  //todo
    }

    @Override
    public W getZ(int index) throws Exception {
        return null;  //todo
    }

    @Override
    public int size() {
        return 0;  //todo
    }
}
