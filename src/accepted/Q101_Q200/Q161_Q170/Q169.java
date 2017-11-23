package accepted.Q101_Q200.Q161_Q170;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ? n/2 ? times.
 * <p>
 * You may assume that the array is non-empty and
 * the majority element always exist in the array.
 */

public class Q169 {

	public int majorityElement(int[] num) {

		if (num.length == 1) {
			return num[0];
		}

		Map<Integer, Integer> m = new HashMap<>();
		for (int n : num) {
			Integer val = m.get(n);
			if (val != null) {
				if (val + 1 > num.length / 2) {
					return n;
				}
				m.put(n, val + 1);

			} else {
				m.put(n, 1);
			}
		}

		return -1;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
