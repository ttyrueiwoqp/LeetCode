package accepted.Q291_Q300;

import org.junit.Test;

/**
 * Created by FJ on 11/8/2015.
 * <p/>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p/>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p/>
 * Your algorithm should run in O(n2) complexity.
 * <p/>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Q300 {

	public int lengthOfLIS(int[] nums) {

		int maxLen = 0;
		int[] lens = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			lens[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lens[i] = Math.max(lens[i], lens[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, lens[i]);
		}

		return maxLen;
	}

	@Test
	public void test() {
		int[] nums = {};
		System.out.println(lengthOfLIS(nums));
	}

}
