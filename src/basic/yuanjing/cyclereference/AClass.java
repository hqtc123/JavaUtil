package basic.yuanjing.cyclereference;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-30
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */
public class AClass {
    public BClass bClass;
    public AClass(){
        this.bClass=new BClass(this);
    }
    public void doSomething(){

    }

    public static void main(String[] args){
        new AClass().doSomething();
    }
}
