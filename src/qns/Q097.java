package qns;

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


		return false;
	}

	@Test
	public void test() {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";

		System.out.println(isInterleave(s1, s2, s3));
		System.out.println(isInterleave(s1, s2, s4));
	}
}
