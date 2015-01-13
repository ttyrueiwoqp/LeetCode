package accepted.Q001_Q020;

import java.util.HashMap;
import java.util.Map;

public class Q001 {

	public int[] twoSum(int[] numbers, int target) {

		// int[] result = new int[2];
		// for (int i = 0; i < numbers.length; i++) {
		// int limit = target - numbers[i];
		// for (int j = i + 1; j < numbers.length; j++) {
		// if (numbers[j] == limit) {
		// result[0] = i + 1;
		// result[1] = j + 1;
		// return result;
		// }
		// }
		// }
		// return result;

		int[] result = new int[2];
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
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
