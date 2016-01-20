package accepted.Q301_Q310;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

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

		for (int i = 1; i <= num.length() / 3; i++) {
			int jLen = i + (num.length() - i) / 2;
			for (int j = i + 1; j <= jLen; j++) {
				long a = atoi(num, 0, i);
				long b = atoi(num, i, j);
				if (getNextIdx(num, a, b, j)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean getNextIdx(String s, long a, long b, int idx) {
		if (a < 0 || b < 0) {
			return false;
		}
		if (idx == s.length()) {
			return true;
		}

		long c = a + b;
		String cStr = String.valueOf(c);
		if (s.substring(idx).startsWith(cStr)) {
			int nextIdx = idx + cStr.length();
			return getNextIdx(s, b, c, nextIdx);
		}

		return false;
	}

	private long atoi(String s, int a, int b) {
		return ((s.charAt(a) != '0' || b - a == 1) && b <= s.length()) ? Long.parseLong(s.substring(a, b)) : -1;
	}


	@Test
	public void test() {
		System.out.println(isAdditiveNumber("101"));
		System.out.println(isAdditiveNumber("123"));
		System.out.println(isAdditiveNumber("112358"));
		System.out.println(isAdditiveNumber("199100199"));
		System.out.println(isAdditiveNumber("11235813213455890144"));
	}


}
