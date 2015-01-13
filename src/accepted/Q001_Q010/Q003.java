package accepted.Q001_Q010;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

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
