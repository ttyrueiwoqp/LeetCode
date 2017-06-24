package accepted.Q551_Q560;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays
 * whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class Q560 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);

        for (int num : nums) {
            sum += num;
            count += m.getOrDefault(sum - k, 0);
            m.merge(sum, 1, Integer::sum);
        }

        return count;
    }
}
