package accepted.Q301_Q400.Q341_Q350;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers
 * in the sliding window.
 * <p>
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class Q346 {

    private int p;
    private int sum;
    private int[] arr;
    private int full;

    /**
     * Initialize your data structure here.
     */
    public Q346(int size) {
        this.p = 0;
        this.sum = 0;
        this.arr = new int[size];
        this.full = 0;
    }

    public double next(int val) {
        sum -= arr[p];
        arr[p] = val;
        sum += arr[p];

        p++;
        if (p == arr.length) {
            p = 0;
            full = 1;
        }

        return 1.0 * sum / (full == 0 ? p : arr.length);
    }

}
