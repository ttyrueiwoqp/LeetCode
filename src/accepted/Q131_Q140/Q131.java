package accepted.Q131_Q140;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by FJ on 11/8/2015.
 * <p/>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p/>
 * Return all possible palindrome partitioning of s.
 * <p/>
 * For example, given s = "aab",
 * Return
 */
public class Q131 {

	public List<List<String>> partition(String s) {

		List<List<Integer>> info = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			info.add(new ArrayList<>());

			for (int j = i; j < s.length(); j++) {
				if (isPalindrome(s, i, j)) {
					info.get(i).add(j);
				}
			}
		}

		return process(info, 0, s);
	}

	private List<List<String>> process(List<List<Integer>> info, int i, String s) {
		List<List<String>> res = new ArrayList<>();

		if (i >= s.length()) {
			res.add(new ArrayList<>());
			return res;
		}

		List<Integer> js = info.get(i);
		for (Integer j : js) {
			List<List<String>> nexts = process(info, j + 1, s);
			for (List<String> next : nexts) {
				next.add(0, s.substring(i, j + 1));
				res.add(next);
			}
		}

		return res;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	@Test
	public void test() {
		System.out.println(partition("aab"));
	}

}
