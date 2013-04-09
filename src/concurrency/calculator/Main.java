package concurrency.calculator;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-9
 * Time: 下午4:46
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 11};
        ConcurrentCalculator calculator = new ConcurrentCalculator();
        Long sum = calculator.sum(nums);
        System.out.println(sum);
        calculator.close();
    }
}
