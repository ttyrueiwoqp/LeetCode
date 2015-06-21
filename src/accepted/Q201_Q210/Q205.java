package accepted.Q201_Q210;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by FJ on 6/20/2015.
 * <p/>
 * Given two strings s and t, determine if they are isomorphic.
 * <p/>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p/>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p/>
 * For example,
 * Given "egg", "add", return true.
 * <p/>
 * Given "foo", "bar", return false.
 * <p/>
 * Given "paper", "title", return true.
 * <p/>
 * Note:
 * You may assume both s and t have the same length.
 */
public class Q205 {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> m = new HashMap<>();
		Set<Character> tSet = new HashSet<>();
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		for (int i = 0; i < sArr.length; i++) {
			Character target = m.get(sArr[i]);

			if (target == null) {
				if (tSet.contains(tArr[i])) {
					return false;
				}
				m.put(sArr[i], tArr[i]);
				tSet.add(tArr[i]);

			} else if (target != tArr[i]) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("ab", "aa"));

	}
}
