package accepted.Q201_Q300.Q291_Q300;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
		if (nums.length == 0) {
			return 0;
		}

		List<Integer> list = new ArrayList<>();
		list.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > list.get(list.size() - 1)) {
				list.add(nums[i]);
			} else {
				for (int j = 0; j < list.size(); j++) {
					if (nums[i] <= list.get(j)) {
						list.set(j, nums[i]);
						break;
					}
				}
			}
		}

		return list.size();
	}

	public int lengthOfLIS2(int[] nums) {

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
