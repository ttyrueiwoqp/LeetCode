package qns;

/**
 * Created by FJ on 6/21/2015.
 * <p/>
 * Note: This is an extension of House Robber.
 * <p/>
 * After robbing those houses on that street,
 * the thief has found himself a new place for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class Q213 {
	public int rob(int[] nums) {

		int max = 0;
		int[] maxs = new int[nums.length];


		for (int i = 0; i < nums.length; i++) {

			if (i < 2) {
				maxs[i] = nums[i];
			} else if (i == 2) {
				maxs[i] = nums[i] + nums[i-2];
			} else if (i > 2){
				maxs[i] = nums[i] + Math.max(maxs[i - 2], maxs[i - 3]);
			}

			if (maxs[i] > max) {
				max = maxs[i];
			}
		}

		return max;


	}
}
