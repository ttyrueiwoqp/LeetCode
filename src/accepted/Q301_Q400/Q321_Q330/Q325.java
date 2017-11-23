package accepted.Q301_Q400.Q321_Q330;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given an array nums and a target value k,
 * find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 * <p>
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * <p>
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * <p>
 * Follow Up:
 * Can you do it in O(n) time?
 */
public class Q325 {

    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (m.containsKey(sum - k)) {
                max = Math.max(max, i - m.get(sum - k));
            }
            if (!m.containsKey(sum)) {
                m.put(sum, i);
            }
        }
        return max;
    }

}
