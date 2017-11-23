package accepted.Q001_Q100.Q091_Q100;

import org.junit.Test;

/**
 * Created by LU-PC on 5/28/2015.
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 */
public class Q091 {
	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		int n0 = 1;
		int n1 = 1;
		for (int i = 1; i < n; i++) {
			int tmp = n1;
			if (s.charAt(i) == '0')
				n1 = 0;
			if ((s.charAt(i - 1) == '2' && s.charAt(i) <= '6') || s.charAt(i - 1) == '1')
				n1 += n0;
			if (n1 == 0)
				return 0;
			n0 = tmp;
		}
		return n1;
	}

	public int numDecodings2(String s) {
		if (s.length() == 1) {
			return 1;
		}

		int res = 0;
		int partLength = Math.min(2, s.length() - 1);
		for (int i = 1; i <= partLength; i++) {

			String subStr1 = s.substring(0, i);
			String subStr2 = s.substring(i);

			if (isValidInt(subStr1)) {
				res += numDecodings2(subStr2) + 1;
			}
		}
		return res;
	}

	private boolean isValidInt(String a) {
		int aInt = Integer.valueOf(a);
		return aInt >= 1 && aInt <= 26 && a.charAt(0) != '0';
	}

	@Test
	public void test() {
		System.out.println(numDecodings("12121212"));
	}
}
