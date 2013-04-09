package concurrency.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-9
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public class ConcurrentCalculator {
    private ExecutorService exec;
    private int cpuCoreNumber;
    private List<Future<Long>> tasks = new ArrayList<Future<Long>>();

    class SumCalculator implements Callable<Long> {

        private int[] nums;
        private int start, end;

        public SumCalculator(final int[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0l;
            for (int i = start; i < end; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    public ConcurrentCalculator() {
        cpuCoreNumber = Runtime.getRuntime().availableProcessors();
        exec = Executors.newFixedThreadPool(cpuCoreNumber);
    }

    public Long sum(final int[] nums) {
        for (int i = 0; i < cpuCoreNumber; i++) {
            int increment = nums.length / cpuCoreNumber + 1;
            int start = increment * i;
            int end = increment * i + increment;
            if (end > nums.length) {
                end = nums.length;
            }

            SumCalculator sumCalc = new SumCalculator(nums, start, end);
            FutureTask<Long> task = new FutureTask<Long>(sumCalc);
            tasks.add(task);
        }

        return getResult();
    }

    private Long getResult() {
        Long result = 0l;
        for (Future<Long> task : tasks) {
            try {
                Long subSum = task.get();
                result += subSum;
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExecutionException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return result;
    }

    public void close() {
        exec.shutdown();
    }
}
