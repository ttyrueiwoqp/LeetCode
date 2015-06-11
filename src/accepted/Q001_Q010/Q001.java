package accepted.Q001_Q010;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Q001 {

	public int[] twoSum(int[] numbers, int target) {

		int[] result = new int[2];
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			Integer key = target - numbers[i];
			Integer value = m.get(key);
			if (value != null) {
				result[0] = value + 1;
				result[1] = i + 1;
				return result;
			} else {
				m.put(numbers[i], i);
			}
		}
		return result;

	}
}
