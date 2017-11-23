package accepted.Q201_Q300.Q211_Q220;

import org.junit.Test;

import java.util.Arrays;

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
		if (nums.length <= 3) {
			int max = 0;
			for (int num : nums) {
				max = Math.max(max, num);
			}
			return max;
		}

		return Math.max(robWithIdx(Arrays.copyOfRange(nums, 0, nums.length - 1)),
				robWithIdx(Arrays.copyOfRange(nums, 1, nums.length)));
	}

	public int robWithIdx(int[] nums) {

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

	/**
	 * 41
	 * 1
	 * 1
	 * 3
	 * 10
	 * 25
	 * 34
	 * 1418
	 * 11
	 * 21
	 */
	@Test
	public void test() {
		int[] a = {1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3};
		System.out.println(rob(a));
		int[] b = {1};
		System.out.println(rob(b));
		int[] c = {1, 1, 1};
		System.out.println(rob(c));
		int[] d = {1, 1, 1, 2};
		System.out.println(rob(d));
		int[] e = {2, 2, 4, 3, 2, 5};
		System.out.println(rob(e));
		int[] f = {2, 1, 2, 6, 1, 8, 10, 10};
		System.out.println(rob(f));
		int[] g = {8, 4, 8, 5, 9, 6, 5, 4, 4, 10};
		System.out.println(rob(g));
		int[] h = {232, 161, 89, 177, 117, 212, 126, 247, 155, 197, 88, 217, 81, 207};
		System.out.println(rob(h));
		int[] i = {2, 7, 9, 3, 1};
		System.out.println(rob(i));
		int[] j = {7, 7, 7, 7, 7, 7, 7};
		System.out.println(rob(j));
	}
}
