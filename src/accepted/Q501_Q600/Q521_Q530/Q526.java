package accepted.Q501_Q600.Q521_Q530;

import java.util.HashSet;
import java.util.Set;

/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is
 * constructed by these N numbers successfully if one of the following is true for the
 * ith position (1 ≤ i ≤ N) in this array:
 * <p>
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 * <p>
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation:
 * <p>
 * The first beautiful arrangement is [1, 2]:
 * <p>
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * <p>
 * The second beautiful arrangement is [2, 1]:
 * <p>
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * Note:
 * N is a positive integer and will not exceed 15.
 */
public class Q526 {

    public int countArrangement(int N) {

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(i);
        }

        return helper(set, 1, N);
    }

    private int helper(Set<Integer> set, int idx, int N) {
        if (set.size() == 0) {
            return 1;
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (set.contains(i) && (idx % i == 0 || i % idx == 0)) {
                set.remove(i);
                res += helper(set, idx + 1, N);
                set.add(i);
            }
        }

        return res;
    }
}
