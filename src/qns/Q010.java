package qns;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") ? true
 * isMatch("aa", ".*") ? true
 * isMatch("ab", ".*") ? true
 * isMatch("aab", "c*a*b") ? true
 */
public class Q010 {

	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		for (int i = 0; i < p.length(); i++) {
			p.charAt(i);
		}

		return false;
	}

	@Deprecated
	private String compress(String s) {

		StringBuilder sb = new StringBuilder();
		char r = ' ';
		boolean repeat = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == r) {
				repeat = true;

			} else {
				if (repeat) {
					sb.append('*');
				}
				r = s.charAt(i);
				sb.append(r);
				repeat = false;
			}
		}

		return sb.toString();
	}

	@Deprecated
	private String compressRegex(String p) {

		int rIdx = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*') {
				rIdx = i + 1;
				while (rIdx < p.length() && p.charAt(rIdx) == p.charAt(i - 1)) {
					rIdx++;
				}
				p = p.substring(0, i + 1) + p.substring(rIdx);
			}
		}
		return p;
	}

	@Test
	public void test() {

		// assertEquals("abc*d", compress("abccd"));
		// assertEquals("a*c*d", compress("aaccd"));
		//
		// assertEquals("a*", compressRegex("a*aaa"));
		// assertEquals("a*b", compressRegex("a*aaab"));
		// assertEquals("a*", compressRegex("a*aaa"));

		assertFalse(isMatch("aa", "a"));
		assertTrue(isMatch("aa", "aa"));
		assertFalse(isMatch("aaa", "aa"));
		assertTrue(isMatch("aa", "a*"));
		assertTrue(isMatch("aa", ".*"));
		assertTrue(isMatch("ab", ".*"));
		assertTrue(isMatch("aab", "c*a*b"));
		assertTrue(isMatch("aaa", "a*a"));
		assertTrue(isMatch("aaa", "a*."));
	}
}
