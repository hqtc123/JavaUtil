package pattern.proxy;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-25
 * Time: 上午11:10
 * To change this template use File | Settings | File Templates.
 */
public class DataList<T, V, W> implements IDataList {
    private ArrayList<ThreeD<T, V, W>> list = new ArrayList<ThreeD<T, V, W>>();

    public ThreeD<T, V, W> get(int i) {
        return list.get(i);
    }

    @Override
    public Object getX(int index) throws Exception {
        return list.get(index).getX();
    }

    @Override
    public Object getY(int index) throws Exception {
        return list.get(index).getY();
    }

    @Override
    public Object getZ(int index) throws Exception {
        return list.get(index).getZ();
    }

    @Override
    public int size() {
        return list.size();
    }
}
