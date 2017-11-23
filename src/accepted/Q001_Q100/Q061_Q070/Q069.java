package accepted.Q001_Q100.Q061_Q070;

import org.junit.Test;

/**
 * Created by LU-PC on 7/6/2015.
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 */
public class Q069 {
	public int mySqrt(int x) {
		if (x == 0) {
			return 0;
		}
		int res = 1;
		int len = (Integer.toString(x).length() + 1) / 2;
		for (int i = 0; i < len; i++) {
			res *= 10;
		}
		return binarySearch(x, 1, res);
	}

	private int binarySearch(int x, int st, int end) {
		int mid = (st + end) / 2;
		if (mid == st) {
			return mid;
		}
		long sq = (long) mid * mid;
		if (sq == x) {
			return mid;
		} else if (sq < x) {
			return binarySearch(x, mid, end);
		} else {
			return binarySearch(x, st, mid);
		}
	}

	@Test
	public void test() {
		System.out.println(mySqrt(2147395599));
	}
}
