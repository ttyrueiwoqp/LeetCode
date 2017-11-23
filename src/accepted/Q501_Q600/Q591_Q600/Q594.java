package accepted.Q501_Q600.Q591_Q600;

import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible
 * subsequences.
 * <p>
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 */
public class Q594 {
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (m.containsKey(e.getKey() + 1)) {
                res = Math.max(res, e.getValue() + m.get(e.getKey() + 1));
            }
        }
        return res;
    }
}
