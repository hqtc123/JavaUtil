package basic.yuanjing.cyclereference;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-30
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */
public class BClass {
    public AClass aClass;

    public BClass(AClass aClass) {
        this.aClass = aClass;
    }
}