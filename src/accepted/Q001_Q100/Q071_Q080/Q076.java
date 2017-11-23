package accepted.Q001_Q100.Q071_Q080;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FJ on 11/15/2015.
 * <p/>
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * <p/>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p/>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p/>
 * If there are multiple such windows, you are guaranteed that
 * there will always be only one unique minimum window in S.
 */
public class Q076 {

	public String minWindow(String s, String t) {

		String res = "";

		Map<Character, Integer> sm = new HashMap<>();
		Map<Character, Integer> tm = new HashMap<>();
		Map<Character, Integer> am = new HashMap<>();
		for (char c : t.toCharArray()) {
			sm.put(c, 0);
			Integer i = tm.get(c);
			if (i == null) {
				tm.put(c, 1);
				am.put(c, 1);
			} else {
				tm.put(c, i + 1);
				am.put(c, i + 1);
			}
		}

		int p = 0, q = 0, len = t.length();
		while (q < s.length() && len > 0) {
			Character c = s.charAt(q);
			Integer si = sm.get(c);
			if (si != null) {
				sm.put(c, si + 1);
				Integer ti = tm.get(c);
				if (ti > 0) {
					tm.put(c, ti - 1);
					len--;
				}
			}
			q++;
		}
		q--;

		if (len > 0) {
			return res;
		}

		res = s.substring(p, q + 1);
		while (p < s.length() && q < s.length()) {
			Character pc = s.charAt(p);
			Integer pi = sm.get(pc);
			if (pi != null) {
				if (q + 1 - p < res.length()) {
					res = s.substring(p, q + 1);
				}

				if (pi.equals(am.get(pc))) {
					q++;
					while (q < s.length()) {
						Character qc = s.charAt(q);
						if (qc == pc) {
							break;
						}

						Integer qi = sm.get(qc);
						if (qi != null) {
							sm.put(qc, qi + 1);
						}
						q++;
					}
					if (q == s.length()) {
						break;
					}
				} else if (pi.compareTo(am.get(pc)) > 0){
					sm.put(pc, pi - 1);
				}
			}
			p++;
		}

		return res;
	}

	@Test
	public void test() {
		System.out.println(minWindow("a", "a"));
		System.out.println(minWindow("a", "aa"));
		System.out.println(minWindow("aa", "aa"));
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}
}
