package accepted.Q091_Q100;

import org.junit.Test;

/**
 * Created by FJ on 11/15/2015.
 * <p/>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p/>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p/>
 * When s3 = "aa db bc bca c", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class Q097 {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		boolean[][] invalid = new boolean[s1.length() + 1][s2.length() + 1];
		return isInterleave(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0, invalid);
	}

	public boolean isInterleave(char[] a1, int i, char[] a2, int j, char[] a3, int k, boolean[][] invalid) {
		if (invalid[i][j]) {
			return false;
		}
		if (k == a3.length) {
			return true;
		}
		boolean isValid = (i < a1.length && a1[i] == a3[k] && isInterleave(a1, i + 1, a2, j, a3, k + 1, invalid))
				|| (j < a2.length && a2[j] == a3[k] && isInterleave(a1, i, a2, j + 1, a3, k + 1, invalid));
		if (!isValid) {
			invalid[i][j] = true;
		}
		return isValid;
	}

	@Test
	public void test() {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";

		String s5 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s6 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s7 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";

		System.out.println(isInterleave(s1, s2, s3));
		System.out.println(isInterleave(s1, s2, s4));

		System.out.println(isInterleave(s5, s6, s7));
	}
}
