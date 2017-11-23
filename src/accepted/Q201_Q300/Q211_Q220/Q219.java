package accepted.Q201_Q300.Q211_Q220;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FJ on 6/24/2015.
 *
 * Given an array of integers and an integer k,
 * find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the difference between i and j is at most k.
 */
public class Q219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer idx = m.get(nums[i]);
			if (idx != null && i - idx <= k) {
				return true;
			} else {
				m.put(nums[i], i);
			}
		}

		return false;
	}

	@Test
	public void test() {
		int[] a = {-1,-1};
		System.out.println(containsNearbyDuplicate(a, 1));
	}
}
