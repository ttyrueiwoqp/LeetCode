package accepted.Q371_Q380;

import java.util.Arrays;

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example:
 * <p>
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * Note that different sequences are counted as different combinations.
 * <p>
 * Therefore the output is 7.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class Q377 {

    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        return helper(nums, target, dp);
    }

    public int helper(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }

        int res = 0;
        for (int num : nums) {
            if (num <= target) {
                res += helper(nums, target - num, dp);
            }
        }
        dp[target] = res;
        return res;
    }

}
