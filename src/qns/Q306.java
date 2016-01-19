package qns;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by FJ on 12/6/2015.
 * <p/>
 * Additive number is a string whose digits can form additive sequence.
 * <p/>
 * A valid additive sequence should contain at least three numbers.
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p/>
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * <p/>
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p/>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 */
public class Q306 {

	public boolean isAdditiveNumber(String num) {

		if (num.length() < 3) {
			return false;
		}

		int[] dp = new int[num.length()];

		int i = 0;
		int a = Integer.parseInt(num.substring(i, dp[0]));
		int b = Integer.parseInt(num.substring(i + dp[0], dp[1]));
		int c = Integer.parseInt(num.substring(i + dp[0] + dp[1], dp[2]));


		return false;
	}

	@Test
	public void test() {
	}

}
