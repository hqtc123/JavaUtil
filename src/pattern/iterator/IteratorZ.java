package pattern.iterator;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
public class IteratorZ<T> extends IteratorXYZ<T> {
    public IteratorZ(DataList ag) {
        super(ag);
    }

    @Override
    public T currentItem() {
        if(isDone()){
            return null;
        }
        return (T)ag.get(i).getZ();
    }
}
