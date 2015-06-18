package accepted.Q121_Q130;

import org.junit.Test;

import java.util.*;

/**
 * Created by LU-PC on 6/18/2015.
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */
public class Q128 {
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> minMap = new HashMap<>();
		Map<Integer, Integer> maxMap = new HashMap<>();

		for (int num : nums) {
			minMap.put(num, num);
			maxMap.put(num, num);
		}

		for (Map.Entry<Integer, Integer> entry : minMap.entrySet()) {
			Integer num = entry.getKey();
			Integer min = entry.getValue();
			Integer max = maxMap.get(num);

			Integer prev = minMap.get(num - 1);
			if (prev != null && prev < min) {
				minMap.put(num, prev);
			}
			Integer next = maxMap.get(num + 1);
			if (next != null && next > max) {
				maxMap.put(num, next);
			}

			max = maxMap.get(num);
			if (prev != null && maxMap.get(prev) < max) {
				maxMap.put(prev, maxMap.get(num));
			}
			min = minMap.get(num);
			if (next != null && minMap.get(next) > min) {
				minMap.put(next, minMap.get(num));
			}
		}

		int maxLength = 0;
		for (Map.Entry<Integer, Integer> entry : minMap.entrySet()) {
			Integer num = entry.getKey();
			maxLength = Math.max(maxMap.get(num) - minMap.get(num) + 1, maxLength);
		}
		return maxLength;
	}

	@Test
	public void test() {
		int[] a = {-3,2,8,5,1,7,-8,2,-8,-4,-1,6,-6,9,6,0,-7,4,5,-4,8,2,0,-2,-6,9,-4,-1};
		System.out.println(longestConsecutive(a));

		int[] b = {-1,0,1,-2,-3,2,-4};
		System.out.println(longestConsecutive(b));
	}
}
