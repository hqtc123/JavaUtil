package basic.str;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-7
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 */
public class BufferBuilder {
    /**
     * String是final修饰的，创建之后不可改变
     * StringBuffer 是线程安全的，常用方法append，insert，replace等
     * StringBuilder非功能同等于buffer，非线程安全
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "err  some torrent bug";
        StringBuffer buf = new StringBuffer(str);
        StringBuilder builder = new StringBuilder("wo are girl");
        builder.replace(0, 2, str);
        System.out.println(builder.toString());
    }
}
