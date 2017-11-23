package accepted.Q001_Q100.Q001_Q010;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Q003 {

	public int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> m = new HashMap<Character, Integer>();
		int count = 0;
		int max = 0;
		int startIdx = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			Integer idx = m.get(c);
			if (idx != null && idx >= startIdx) {
				if (count > max) {
					max = count;
				}
				count = i - idx;
				startIdx = idx + 1;
			} else {
				count++;
			}

			m.put(s.charAt(i), i);
		}

		if (count > max) {
			max = count;
		}

		return max;
	}

	@Test
	public void test() {
		assertEquals(
				12,
				lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}

}
