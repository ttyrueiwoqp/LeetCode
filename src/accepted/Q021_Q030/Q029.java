package accepted.Q021_Q030;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q029 {

	public int divide(int dividend, int divisor) {

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (divisor == 1) {
			return dividend;
		}
		if (divisor == -1 && dividend == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (dividend > 0) {
			return -divide(-dividend, divisor);
		} else if (divisor > 0) {
			return -divide(dividend, -divisor);
		}

		List<Integer> drs = new ArrayList<Integer>();
		List<Integer> ns = new ArrayList<Integer>();

		int res = 0;
		int n = 1, dd = dividend, dr = divisor;
		while (dd <= dr) {
			drs.add(dr);
			ns.add(n);

			if (Integer.MIN_VALUE - dr >= dr) {
				return divide(dividend - dr, divisor) + n;
			} else {
				dr += dr;
				n += n;
			}
		}

		dr = divisor;
		int i = drs.size() - 1;
		while (i >= 0) {
			if (dd < drs.get(i)) {
				dd -= drs.get(i);
				res += ns.get(i);
			} else if (dd == drs.get(i)) {
				res += ns.get(i);
				break;
			}
			i--;
		}

		return res;

	}

	@Test
	public void test() {

		assertEquals(Integer.MIN_VALUE, divide(-2147483648, 1));
		assertEquals(5, divide(35, 7));
		assertEquals(5, divide(-35, -7));
		assertEquals(1073741823, divide(1073741823, 1));
		assertEquals(2147483647, divide(2147483647, 1));
		assertEquals(Integer.MAX_VALUE, divide(-2147483648, -1));
		assertEquals(2147483647 / 2, divide(2147483647, 2));

	}

}
