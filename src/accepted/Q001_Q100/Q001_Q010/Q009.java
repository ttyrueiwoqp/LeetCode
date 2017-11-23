package accepted.Q001_Q100.Q001_Q010;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * click to show spoilers.
 * <p>
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 * you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 */
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
