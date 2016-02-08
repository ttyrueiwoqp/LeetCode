package accepted.Q311_Q320;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by FJ on 1/24/2016.
 * <p/>
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p/>
 * Example:
 * Given "bcabc"
 * Return "abc"
 * <p/>
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class Q316 {

	public String removeDuplicateLetters(String s) {

		if (s.length() < 2) {
			return s;
		}

		char[] chars = s.toCharArray();
		List<Character> list = new ArrayList<>();
		Map<Character, Integer> m = new HashMap<>();

		for (char c : chars) {
			Integer cnt = m.get(c);
			if (cnt == null) {
				cnt = 0;
			}
			m.put(c, ++cnt);
		}

		for (char c : chars) {
			m.put(c, m.get(c) - 1);
			if (list.contains(c)) {
				continue;
			}
			while (!list.isEmpty()
					&& c < list.get(list.size() - 1)
					&& m.get(list.get(list.size() - 1)) > 0) {
				list.remove(list.size() - 1);
			}
			list.add(c);
		}

		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			sb.append(c);
		}

		return sb.toString();
	}

	@Test
	public void test() {

		assertEquals("cd", removeDuplicateLetters("dcd"));
		assertEquals("abc", removeDuplicateLetters("bcabc"));
		assertEquals("acdb", removeDuplicateLetters("cbacdcbc"));
		assertEquals("bac", removeDuplicateLetters("bbcaac"));
		assertEquals("abc", removeDuplicateLetters("abacb"));


	}
}
