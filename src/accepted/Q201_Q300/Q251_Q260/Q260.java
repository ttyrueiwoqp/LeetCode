package accepted.Q201_Q300.Q251_Q260;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LU-PC on 10/8/2015.
 * <p>
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * For example:
 * <p>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */
public class Q260 {

	public int[] singleNumber(int[] nums) {

		Set<Integer> s = new HashSet<>();

		for (int num : nums) {
			if (s.contains(num)) {
				s.remove(num);
			} else {
				s.add(num);
			}
		}

		int[] result = new int[2];
		int i = 0;
		for (Integer num : s) {
			result[i] = num;
			i++;
		}

		return result;
	}
}
