package accepted.Q191_Q200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void test() {
		int[] a = {1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3};
		System.out.println(rob(a));
		int[] b = {1};
		System.out.println(rob(b));
		int[] c = {1, 1};
		System.out.println(rob(c));
		int[] d = {1, 1, 2};
		System.out.println(rob(d));
		int[] e = {2, 4, 3, 2, 5};
		System.out.println(rob(e));
		int[] f = {2, 1, 2, 6, 1, 8, 10, 10};
		System.out.println(rob(f));
	}
}
