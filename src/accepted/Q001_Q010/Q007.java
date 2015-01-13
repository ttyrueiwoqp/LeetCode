package accepted.Q001_Q010;

import static org.junit.Assert.*;

import org.junit.Test;

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
