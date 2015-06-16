package accepted.Q001_Q010;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
 * then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p>
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Q007 {

	public int reverse(int x) {
		int r = 0, y = 0;

		if (x < 0) {
			if (x == Integer.MIN_VALUE) {
				return 0;
			} else {
				return -reverse(-x);
			}
		}

		while (x / 10 >= 0 && x != 0) {
			r = x % 10;
			x /= 10;
			if ((Integer.MAX_VALUE - r) / 10 >= y) {
				y = y * 10 + r;
			} else {
				return 0;
			}
		}

		return y;
	}

	@Test
	public void test() {
		assertEquals(321, reverse(123));
		assertEquals(321, reverse(1230));
		assertEquals(-321, reverse(-123));
		assertEquals(0, reverse(1000000003));
		assertEquals(0, reverse(-2147483648));
	}

}
