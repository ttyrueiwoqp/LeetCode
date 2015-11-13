package qns;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FJ on 11/13/2015.
 * <p/>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p/>
 * Below is one possible representation of s1 = "great":
 * <p/>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p/>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p/>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p/>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p/>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p/>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class Q087 {

	public boolean isScramble(String s1, String s2) {
		Map<Character, Integer> m = new HashMap<>();
		for (char c : s1.toCharArray()) {
			Integer i = m.get(c);
			if (i == null) {
				m.put(c, 1);
			} else {
				m.put(c, i + 1);
			}
		}
		for (char c : s2.toCharArray()) {
			Integer i = m.get(c);
			if (i == null || i == 0) {
				return false;
			} else {
				m.put(c, i - 1);
			}
		}
		return true;
	}

	@Test
	public void test() {
		System.out.println(isScramble("great", "rgtae"));
		System.out.println(isScramble("abcd", "bdac"));
	}
}
