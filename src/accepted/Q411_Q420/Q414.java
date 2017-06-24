package accepted.Q411_Q420;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers,
 * return the third maximum number in this array.
 * If it does not exist, return the maximum number.
 * The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist,
 * so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class Q414 {

    public int thirdMax(int[] nums) {
        int[] maxs = new int[3];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            set.add(curr);
            for (int j = 0; j < maxs.length; j++) {
                if (maxs[j] == curr) {
                    break;
                } else if (maxs[j] < curr) {
                    int temp = curr;
                    curr = maxs[j];
                    maxs[j] = temp;
                }
            }
        }
        return set.size() < 3 ? maxs[0] : maxs[2];
    }
}
