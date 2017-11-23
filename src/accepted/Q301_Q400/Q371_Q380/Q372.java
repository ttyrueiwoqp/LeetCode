package accepted.Q301_Q400.Q371_Q380;

/**
 * Your task is to calculate ab mod 1337
 * where a is a positive integer and b is an extremely large positive integer
 * given in the form of an array.
 * <p>
 * Example1:
 * <p>
 * a = 2
 * b = [3]
 * <p>
 * Result: 8
 * Example2:
 * <p>
 * a = 2
 * b = [1,0]
 * <p>
 * Result: 1024
 */
public class Q372 {
    public int superPow(int a, int[] b) {
        int res = 1;
        for (int d : b) {
            res = power(res, 10, 1337) * power(a, d, 1337) % 1337;
        }
        return res;
    }

    private int power(int x, int y, int z) {
        long res = 1;
        for (int i = 0; i < y; i++) {
            res = res * x % z;
        }
        return (int) res;
    }
}
