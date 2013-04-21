package pattern.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午11:07
 * To change this template use File | Settings | File Templates.
 */
public class ProxyX<T,V,W> extends DataListProxy<T,V,W>{
    protected ProxyX(IDataList<T, V, W> real) {
        super(real);
    }

    public T getX(int i) throws Exception {
        return real.getX(i);
    }
}
