package qns;

import org.junit.Test;

/**
 * Created by LU-PC on 10/12/2015.
 * <p>
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * <p>
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class Q233 {

	public int countDigitOne(int n) {

		int res = 0;
		String s = Integer.toString(n);
		int unit = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			String st = s.substring(0, i);
			String mid = s.substring(i, i + 1);
			String end = s.substring(i + 1);
			unit *= 10;
			int c = compute(st, mid, end, unit);
			res += c;
		}

		return res;
	}

	private int compute(String st, String mid, String end, int unit) {
		int a = (st.isEmpty()) ? 0 : Integer.parseInt(st);
		int b = Integer.parseInt(mid);
		int c = (end.isEmpty()) ? 0 : Integer.parseInt(end);
		int d = Integer.parseInt(mid + end);

		int res = 0;
		res += a + Math.min(b, 1);
		if (b > 0) {
			res += Math.min(d - unit, unit);
		}
		System.out.println("compute " + st + " " + mid + " " + end + "=" + res);
		return res;
	}

	@Test
	public void test() {
		System.out.println(countDigitOne(100));
	}


}
