package accepted.Q131_Q140;

import org.junit.Test;

import java.util.*;

/**
 * Created by FJ on 10/19/2015.
 * <p/>
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p/>
 * Return all such possible sentences.
 * <p/>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p/>
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class Q140 {
	public List<String> wordBreak(String s, Set<String> wordDict) {

		if (!canWordBreak(s, wordDict)) {
			return new ArrayList<>();
		}

		List<List<String>> res = new ArrayList<>();

		for (int i = 0; i <= s.length(); i++) {
			List<String> list = new ArrayList<>();
			res.add(i, list);

			for (int j = i; j >= 0; j--) {
				String sub = s.substring(j, i);
				if (wordDict.contains(sub)) {
					if (j == 0) {
						list.add(sub);
					} else {
						for (String js : res.get(j)) {
							list.add(js + " " + sub);
						}
					}
				}
			}
		}

		return res.get(s.length());
	}

	private boolean canWordBreak(String s, Set<String> wordDict) {

		Deque<Integer> queue = new ArrayDeque<>();

		queue.add(0);
		int i, j, maxWordLen = 0;
		for (String w : wordDict) {
			maxWordLen = Math.max(w.length(), maxWordLen);
		}

		while (!queue.isEmpty()) {
			i = queue.remove();

			int len = Math.min(i + maxWordLen, s.length());
			for (j = i + 1; j <= len; j++) {
				String sub = s.substring(i, j);
				if (wordDict.contains(sub)) {
					if (j == s.length()) {
						return true;
					}
					if (!queue.contains(j)) {
						queue.add(j);
					}
				}
			}
		}

		return false;
	}

	@Test
	public void test() {
//		String[] ss = {"cat", "cats", "and", "sand", "dog"};
//		Set<String> set = new HashSet<>();
//		for (String s : ss) {
//			set.add(s);
//		}
//
//		System.out.println(wordBreak("catsanddog", set));


		String[] ss = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaab"};
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(ss));

		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaab", set));

	}
}
