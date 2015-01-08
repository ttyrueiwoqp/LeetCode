package accepted;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Q005 {

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		int length = s.length();
		String result = "";

		int sign = 1;
		int i = length / 2;
		int incr = 0;
		boolean terminate = false;
		while (i < length && i >= 0) {
			String p = "";
			int st = i - 1;
			int end = i + 1;
			int m = -1;
			int n = -1;
			while (st >= 0 && end < length && s.charAt(st) == s.charAt(end)) {
				m = st;
				n = end;
				st--;
				end++;
			}
			if (m != -1) {
				p = s.substring(m, n + 1);
				result = p.length() > result.length() ? p : result;
				if (result.length() > i * 2
						|| result.length() > (length - 1 - i) * 2) {
					terminate = true;
				}
			}

			p = "";
			st = i - 1;
			end = i;
			m = -1;
			n = -1;
			while (st >= 0 && end < length && s.charAt(st) == s.charAt(end)) {
				m = st;
				n = end;
				st--;
				end++;
			}
			if (m != -1) {
				p = s.substring(m, n + 1);
				result = p.length() > result.length() ? p : result;
				if (result.length() > i * 2
						|| result.length() > (length - 1 - i) * 2) {
					terminate = true;
				}
			}

			if (terminate) {
				return result;
			}

			incr++;
			i = i + incr * sign;
			sign = -sign;
		}

		return result;
	}

	public String findLongestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";

		char[] s2 = addBoundaries(s.toCharArray());
		int[] p = new int[s2.length];
		int c = 0, r = 0; // Here the first element in s2 has been processed.
		int m = 0, n = 0; // The walking indices to compare if two elements are
							// the same
		for (int i = 1; i < s2.length; i++) {
			if (i > r) {
				p[i] = 0;
				m = i - 1;
				n = i + 1;
			} else {
				int i2 = c * 2 - i;
				if (p[i2] < (r - i)) {
					p[i] = p[i2];
					m = -1; // This signals bypassing the while loop below.
				} else {
					p[i] = r - i;
					n = r + 1;
					m = i * 2 - n;
				}
			}
			while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
				p[i]++;
				m--;
				n++;
			}
			if ((i + p[i]) > r) {
				c = i;
				r = i + p[i];
			}
		}
		int len = 0;
		c = 0;
		for (int i = 1; i < s2.length; i++) {
			if (len < p[i]) {
				len = p[i];
				c = i;
			}
		}
		char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);
		return String.valueOf(removeBoundaries(ss));
	}

	private char[] addBoundaries(char[] cs) {
		if (cs == null || cs.length == 0)
			return "||".toCharArray();

		char[] cs2 = new char[cs.length * 2 + 1];
		for (int i = 0; i < (cs2.length - 1); i = i + 2) {
			cs2[i] = '|';
			cs2[i + 1] = cs[i / 2];
		}
		cs2[cs2.length - 1] = '|';
		return cs2;
	}

	private char[] removeBoundaries(char[] cs) {
		if (cs == null || cs.length < 3)
			return "".toCharArray();

		char[] cs2 = new char[(cs.length - 1) / 2];
		for (int i = 0; i < cs2.length; i++) {
			cs2[i] = cs[i * 2 + 1];
		}
		return cs2;
	}

	public String findLongestPalindrome2(String string) {
		final int strlen = string.length();

		int pLen = 1;
		int pSt = 0;

		if (strlen == 0) {
			return "";
		}
		final int helperLength = 2 * strlen - 1;
		final int[] helper = new int[helperLength];
		
		helper[0] = 1;
		
		int lastIndex = 0;
		int lastMax = 0;
		List<Integer> cnt = new ArrayList<Integer>();
		for (int i = 1; i < helperLength - pLen; i++) {
			cnt.add(0);
			final int base = i / 2;
			final int mod = i % 2;
			int radius, offset;
			if (i < lastMax) {
				radius = Math.min(helper[2 * lastIndex - i], lastMax - i);
				offset = (radius + 1 - mod) / 2;
			} else {
				offset = radius = 1 - mod;
			}
			final int offsetLimit = Math.min(base + 1, strlen - base - mod);
			while (offset < offsetLimit
					&& string.charAt(base - offset) == string.charAt(base
							+ offset + mod)) {
				radius += 2;
				offset++;
				cnt.add(1);
			}
			if ((helper[i] = radius) > pLen) {
				pSt = base + mod - radius / 2;
				pLen = radius;
			}
			if ((radius += i) > lastMax) {
				lastIndex = i;
				lastMax = radius;
			}
		}

		System.out.println(cnt);
		return string.substring(pSt, pSt + pLen);
	}
	
	
	public String findLongestPalindrome3(String s) {
		String t = preProcess(s);
		int length = t.length();
		int[] p = new int[length];
		int c = 0, r = 0;
		
		for (int i = 1; i < length-1; i++) {
			int j = 2 * c - i;
			
			if (r > i) {
				if (r - i > p[j]) {
					p[i] = p[j];	
				} else {
					p[i] = r - i;
				}
			} else {
				p[i] = 0;
			}
			
			while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
				p[i]++;
			}
			
			if (i + p[i] > r) {
				c = i;
				r = i + p[i];
			}
		}
		
		int maxLen = 0;
		int cIdx = 0;
		
		for (int i = 1; i < length-1; i++) {
			if (p[i] > maxLen) {
				maxLen = p[i];
				cIdx = i;
			}
		}
		
		return s.substring((cIdx - 1 - maxLen) / 2, (cIdx - 1 + maxLen) / 2);
		
	}
	
	public String preProcess(String s) {
		int length = s.length();
		if (length == 0) {
			return "^$";
		}
		String ret = "^";
		for (int i = 0; i < length; i++) {
			ret += "#" + s.charAt(i);
		}
		ret += "#$";
		return ret;
	}
	

	@Test
	public void test() {
		
		assertEquals("bcdcbadabcdcb", findLongestPalindrome3("abcdcbadabcdcb"));
		assertEquals("bacab", findLongestPalindrome3("abacabdd"));
		assertEquals("ccc", findLongestPalindrome3("ccc"));
		assertEquals("cccc", findLongestPalindrome3("cccc"));
		assertEquals(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				findLongestPalindrome3("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		
	}
}
