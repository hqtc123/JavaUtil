package pattern.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午11:09
 * To change this template use File | Settings | File Templates.
 */
public class ProxyY<T,V,W> extends DataListProxy<T,V,W> {
    protected ProxyY(IDataList<T, V, W> real) {
        super(real);
    }

    public V getY(int i) throws Exception {
        return real.getY(i);
    }
}
