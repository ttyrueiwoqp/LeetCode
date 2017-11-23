package accepted.Q401_Q500.Q411_Q420;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Q416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int[] reverse = new int[nums.length];
        Arrays.sort(nums);

        int idx = nums.length - 1;
        for (int num : nums) {
            sum += num;
            reverse[idx] = num;
            idx--;
        }

        return sum % 2 == 0 && helper(reverse, 0, sum / 2);

    }

    private boolean helper(int[] nums, int i, int target) {
        for (int j = i; j < nums.length; j++) {
            if (nums[j] == target) {
                return true;
            } else if (nums[j] > target) {
                continue;
            } else if (helper(nums, j + 1, target - nums[j])) {
                return true;
            }
        }
        return false;
    }
}
