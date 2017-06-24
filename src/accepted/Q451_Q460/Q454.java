package accepted.Q451_Q460;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
 * there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Q454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        fill(m1, A, B);
        fill(m2, C, D);

        int res = 0;
        for (Map.Entry<Integer, Integer> e : m1.entrySet()) {
            Integer count2 = m2.get(-e.getKey());
            if (count2 != null) {
                res += e.getValue() * count2;
            }
        }

        return res;
    }

    private void fill(Map<Integer, Integer> m, int[] A, int[] B) {

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                Integer count = m.get(sum);
                if (count == null) {
                    count = 0;
                }
                m.put(sum, count + 1);
            }
        }
    }
}
