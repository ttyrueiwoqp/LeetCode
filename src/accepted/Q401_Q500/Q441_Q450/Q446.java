package accepted.Q401_Q500.Q441_Q450;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequences:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of
 * integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
 * <p>
 * A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence
 * A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.
 * <p>
 * The function should return the number of arithmetic subsequence slices in the array A.
 * <p>
 * The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000.
 * The output is guaranteed to be less than 231-1.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [2, 4, 6, 8, 10]
 * <p>
 * Output: 7
 * <p>
 * Explanation:
 * All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 */
public class Q446 {

    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;

        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            m.putIfAbsent(A[i], new ArrayList<>());
            m.get(A[i]).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> e : m.entrySet()) {
            if (e.getValue().size() > 2) {
                int n = e.getValue().size();
                res += (1 << n) - 1 - n - n * (n - 1) / 2;
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] == A[i] || (long) A[j] - A[i] > Integer.MAX_VALUE || (long) A[j] - A[i] < Integer.MIN_VALUE) {
                    continue;
                }
                res += helper(A, A[j], A[j] - A[i], j, m);
            }
        }

        return res;
    }

    private int helper(int[] A, int curr, int d, int idx, Map<Integer, List<Integer>> m) {
        if ((long) curr + d > Integer.MAX_VALUE || (long) curr + d < Integer.MIN_VALUE || !m.containsKey(curr + d)) {
            return 0;
        }

        int res = 0;
        curr += d;
        List<Integer> list = m.get(curr);
        for (int i : list) {
            if (i > idx) {
                res += helper(A, curr, d, i, m) + 1;
            }
        }
        return res;
    }
}
