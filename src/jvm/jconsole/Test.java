package jvm.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qing on 2016/4/10.
 */
public class Test {
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObj> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObj());
        }

        System.gc();
    }

    public static void main(String args[]) throws InterruptedException {
        fillHeap(1000);
    }
}
