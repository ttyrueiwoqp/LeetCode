package accepted.Q311_Q320;

import org.junit.Test;

import java.util.*;

/**
 * Created by FJ on 1/24/2016.
 * <p/>
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. You may assume that each word will contain
 * only lower case letters. If no such two words exist, return 0.
 * <p/>
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * <p/>
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * <p/>
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 */
public class Q318 {

	// NOT OPTIMISED. USE BITMAP INSTEAD.
	public int maxProduct(String[] words) {

		Map<Character, Set<Integer>> m = new HashMap<>();
		int len = words.length;

		for (int i = 0; i < len; i++) {
			char[] chars = words[i].toCharArray();
			for (char c : chars) {
				Set<Integer> idxs = m.get(c);
				if (idxs == null) {
					idxs = new HashSet<>();
					m.put(c, idxs);
				}
				idxs.add(i);
			}
		}

		int[][] pair = new int[len][len];

		for (int i = 0; i < len; i++) {
			char[] chars = words[i].toCharArray();
			for (char c : chars) {
				for(int j : m.get(c)) {
					pair[i][j] = 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (pair[i][j] == 0) {
					max = Math.max(words[i].length() * words[j].length(), max);
				}
			}
		}

		return max;
	}

	@Test
	public void test() {
		String[] a = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		String[] b = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		String[] c = {"a", "aa", "aaa", "aaaa"};
		System.out.println(maxProduct(a));
		System.out.println(maxProduct(b));
		System.out.println(maxProduct(c));
	}
}