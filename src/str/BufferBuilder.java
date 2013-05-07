package str;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-7
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 */
public class BufferBuilder {
    public static void main(String[] args) {
        String str = "err  some torrent bug";
        StringBuffer buf = new StringBuffer(str);
        StringBuilder builder = new StringBuilder("wo are girl");
        builder.replace(0, 2, str);
        System.out.println(builder.toString());
    }
}
