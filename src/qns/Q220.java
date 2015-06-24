package qns;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FJ on 6/24/2015.
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that
 * the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class Q220 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer idx = m.get(nums[i]);
			if (idx != null && i - idx <= k) {
				return true;
			} else {
				m.put(nums[i] + t, i);
			}
		}

		return false;

	}

	@Test
	public void test() {
		int[] a = {-1,-1};
		System.out.println(containsNearbyAlmostDuplicate(a, 1, 1));
	}
}
