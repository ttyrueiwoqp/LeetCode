package accepted.Q011_Q020;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Q016 {

	public int threeSumClosest(int[] num, int target) {

		int min = Integer.MAX_VALUE;
		int res = Integer.MAX_VALUE;
		if (num == null || num.length < 3) {
			return res;
		}
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < num.length; j++) {
				if (j > i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				for (int k = num.length - 1; k > j; k--) {
					if (k < num.length - 1 && num[k] == num[k + 1]) {
						continue;
					}
					int sum = num[i] + num[j] + num[k];
					int temp = Math.abs(sum - target);
					if (temp == 0) {
						return sum;
					} else if (temp < min) {
						min = temp;
						res = sum;
					}
				}
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] s = {-1, 2, 1, -4};
		assertEquals(2, threeSumClosest(s, 1));
	}

}
