package accepted.Q041_Q050;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LU-PC on 10/26/2015.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "*") ? true
 * isMatch("aa", "a*") ? true
 * isMatch("ab", "?*") ? true
 * isMatch("aab", "c*a*b") ? false
 */
public class Q044 {

	public boolean isMatch(String s, String p) {

		s += '\0';
		p += '\0';

		int m = p.length();
		int n = s.length();

		int[] states = new int[m + 1];
		int[] old = new int[m + 1];
		old[0] = 1;

		for (int i = 0; i < n; i++) {
			char si = s.charAt(i);
			states = new int[m + 1];

			for (int j = 0; j < m; j++) {
				char pj = p.charAt(j);

				if (old[j] == 1) {
					if (pj == '*') {
						old[j + 1] = 1;
						states[j] = 1;
						states[j + 1] = 1;
					} else if (pj == '?' || pj == si) {
						states[j + 1] = 1;
					}
				}
			}
			old = states;
		}

		return states[m] == 1;
	}

	@Test
	public void test() {
		assertTrue(isMatch("", ""));
		assertTrue(isMatch("", "*"));
		assertFalse(isMatch("", "?"));
		assertFalse(isMatch("aa", "a"));
		assertTrue(isMatch("aa", "aa"));
		assertFalse(isMatch("aaa", "aa"));
		assertTrue(isMatch("aa", "*"));
		assertTrue(isMatch("aa", "a*"));
		assertTrue(isMatch("ab", "?*"));
		assertFalse(isMatch("aab", "c*a*b"));
		assertTrue(isMatch("aaabcacac", "a*ab*c"));
	}
}
