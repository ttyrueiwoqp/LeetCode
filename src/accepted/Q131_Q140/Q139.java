package accepted.Q131_Q140;

import org.junit.Test;

import java.util.*;

/**
 * Created by LU-PC on 10/19/2015.
 * <p/>
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * <p/>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p/>
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Q139 {

	public boolean wordBreak(String s, Set<String> wordDict) {

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
//		Set<String> set = new HashSet<>();
//		set.add("leet");
//		set.add("code");
//
//		System.out.println(wordBreak("leetcode", set));

		String[] ss = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaab"};
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(ss));

		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", set));



	}

}
