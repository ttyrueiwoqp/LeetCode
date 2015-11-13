package accepted.Q201_Q210;

import org.junit.Test;

/**
 * Created by FJ on 11/13/2015.
 * <p/>
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * <p/>
 * For example, given the range [5, 7], you should return 4.
 */
public class Q201 {

	public int rangeBitwiseAnd(int m, int n) {

		int diff = -1;

		int i = m, j = n, k = 0;
		while (!(i == 0 && j == 0)) {
			if (i % 2 != j % 2) {
				diff = k;
			}
			i >>= 1;
			j >>= 1;
			k++;
		}

		if (diff == -1) {
			return m;
		}

		diff++;
		return m >> diff << diff;
	}

	@Test
	public void test() {
		System.out.println(rangeBitwiseAnd(5, 7));
		System.out.println(rangeBitwiseAnd(1, 3));
		System.out.println(rangeBitwiseAnd(1, Integer.MAX_VALUE));
	}
}
