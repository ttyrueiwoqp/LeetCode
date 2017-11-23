package accepted.Q201_Q300.Q281_Q290;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by LU-PC on 10/14/2015.
 * <p>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between
 * a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class Q290 {

	public boolean wordPattern(String pattern, String str) {

		int i = 0;
		Map<String, String> m1 = new HashMap<>();
		Map<String, String> m2 = new HashMap<>();
		StringTokenizer st = new StringTokenizer(str, " ");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (i == pattern.length()) {
				return false;
			}
			String p = pattern.substring(i, i + 1);

			if (!isRightPattern(p, s, m1)
					|| !isRightPattern(s, p, m2)) {
				return false;
			}
			i++;
		}

		return i == pattern.length();
	}

	private boolean isRightPattern(String key, String v, Map<String, String> m) {

		String val = m.get(key);
		if (val == null) {
			m.put(key, v);
		} else if (!val.equals(v)) {
			return false;
		}
		return true;
	}

	@Test
	public void test() {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
		System.out.println(wordPattern("aaa", "a a a a"));
	}

}
