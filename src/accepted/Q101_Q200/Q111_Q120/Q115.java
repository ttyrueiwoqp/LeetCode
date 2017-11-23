package accepted.Q101_Q200.Q111_Q120;

import org.junit.Test;

/**
 * Created by FJ on 3/2/2016.
 * <p/>
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * <p/>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p/>
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * <p/>
 * Return 3.
 */
public class Q115 {

	public int numDistinct(String s, String t) {

		int sLen = s.length();
		int tLen = t.length();

		if (sLen < tLen) {
			return 0;
		}

		int[][] dp = new int[tLen + 1][sLen + 1];

		for (int j = 0; j < sLen; j++) {
			dp[0][j] = 1;
		}

		for (int i = 1; i <= tLen; i++) {
			char tc = t.charAt(i - 1);

			for (int j = 1; j <= sLen; j++) {
				dp[i][j] = dp[i][j - 1];

				char sc = s.charAt(j - 1);
				if (tc == sc) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}

//		for (int i = 1; i <= tLen; i++) {
//			for (int j = 1; j <= sLen; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}

		return dp[tLen][sLen];
	}

	@Test
	public void test() {
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct(s, t));
	}
}
