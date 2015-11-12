package accepted.Q201_Q210;

import org.junit.Test;

/**
 * Created by LU-PC on 6/29/2015.
 * <p>
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ? s.
 * If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class Q209 {
	public int minSubArrayLen(int s, int[] nums) {
		int i = 0, j = 0, minLen = 0, sum = 0;
		while (j < nums.length) {
			sum += nums[j];
			while (sum >= s) {
				minLen = (minLen == 0) ?  j - i + 1 : Math.min(minLen, j - i + 1);
				sum -= nums[i];
				i++;
			}
			j++;
		}
		return minLen;
	}

	@Test
	public void test() {
		int[] a = {2, 3, 1, 2, 4, 3};
		System.out.println(minSubArrayLen(7, a));
	}
}
