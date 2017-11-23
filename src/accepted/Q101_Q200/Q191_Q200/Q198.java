package accepted.Q101_Q200.Q191_Q200;

/**
 * Created by LU-PC on 5/28/2015.
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class Q198 {
	public int rob(int[] nums) {

		int max = 0;
		int[] maxs = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {

			if (i < 2) {
				maxs[i] = nums[i];
			} else if (i == 2) {
				maxs[i] = nums[i] + nums[i - 2];
			} else if (i > 2) {
				maxs[i] = nums[i] + Math.max(maxs[i - 2], maxs[i - 3]);
			}

			if (maxs[i] > max) {
				max = maxs[i];
			}
		}

		return max;
	}

}
