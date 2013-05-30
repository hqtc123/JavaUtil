package basic.yuanjing.inherit;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-30
 * Time: 下午7:50
 * To change this template use File | Settings | File Templates.
 */
class Supper extends Vector {
    private class Sub extends Supper {
        public Sub() {

        }

        private int priJ = 90;
        int i = 0;
    }

    public class Soup extends Sub {
        public Soup() {
            super();
        }

        /**
         * 子类可以访问private父类的非private成员变量
         * 子类不能访问任何父类的private变量
         * priJ 不可见
         */
        public void doSome() {
            i++;
        }
    }


}
