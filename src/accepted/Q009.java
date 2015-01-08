package accepted;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q009 {

	public boolean isPalindrome(int x) {

		int r = 0, y = 0, m = x;

		if (x < 0) {
			return false;
		}

		while (x / 10 >= 0 && x != 0) {
			r = x % 10;
			x /= 10;
			if ((Integer.MAX_VALUE - r) / 10 >= y) {
				y = y * 10 + r;
			} else {
				return false;
			}
		}

		return m == y;
	}

	@Test
	public void test() {
		assertTrue(isPalindrome(12321));
	}
}
