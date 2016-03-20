package bit;

/**
 * Created by Qing on 2016/3/19.
 */
public class BitCal {
    public static int num1(int x) {
        int count = 0;
        while (x > 0) {
            count++;
            x = x & (x - 1);
        }
        return count;
    }

    public static int num0(int x) {
        int count = 0;
        System.out.println(Integer.toBinaryString(x));
        x = x | (x + 1);
        System.out.println(Integer.toBinaryString(x));
        return x;
    }

    public static void main(String[] args) {
        for (int i =1; i<11;i++){
            System.out.println("==========");
            BitCal.num0(i);
        }
    }
}
