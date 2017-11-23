package accepted.Q401_Q500.Q421_Q430;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * <p>
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * <p>
 * Could you do this in O(n) runtime?
 * <p>
 * Example:
 * <p>
 * Input: [3, 10, 5, 25, 2, 8]
 * <p>
 * Output: 28
 * <p>
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class Q421 {

    public int findMaximumXOR(int[] nums) {

        int mask = 0, max = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int temp = (1 << i) | max;
            for (Integer n : set) {
                if (set.contains(temp ^ n)) {
                    max = temp;
                    break;
                }
            }

        }

        return max;
    }
}
