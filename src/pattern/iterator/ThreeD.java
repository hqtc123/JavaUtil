package pattern.iterator;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午10:17
 * To change this template use File | Settings | File Templates.
 */
public class ThreeD<T,W,V>{
    private T t;
    private W w;
    private V v;

    public ThreeD(T t, W w, V v) {
        this.t = t;
        this.w = w;
        this.v = v;
    }

    public T getX() {
        return t;
    }

    public W getY() {
        return w;
    }

    public V getZ() {
        return v;
    }
}
