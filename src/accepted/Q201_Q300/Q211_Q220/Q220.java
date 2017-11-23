package accepted.Q201_Q300.Q211_Q220;

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
		if (k < 1 || t < 0) {
			return false;
		}
		Map<Long, Long> m = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long newNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = newNum / ((long) t + 1);
			if (m.containsKey(bucket)
					|| (m.containsKey(bucket - 1) && newNum - m.get(bucket - 1) <= t)
					|| (m.containsKey(bucket + 1) && m.get(bucket + 1) - newNum <= t)) {
				return true;
			}
			if (m.entrySet().size() >= k) {
				long lastNewNum = (long) nums[i - k] - Integer.MIN_VALUE;
				long lastBucket = lastNewNum / ((long) t + 1);
				m.remove(lastBucket);
			}
			m.put(bucket, newNum);
		}
		return false;
	}


	@Test
	public void test() {
		int[] a = {1,3,1};
		System.out.println(containsNearbyAlmostDuplicate(a, 1, 1));
	}
}
