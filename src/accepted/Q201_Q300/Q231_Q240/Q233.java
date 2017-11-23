package accepted.Q201_Q300.Q231_Q240;

import org.junit.Test;

/**
 * Created by LU-PC on 10/12/2015.
 * <p/>
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * <p/>
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class Q233 {

	// 1 1 3
	// 11*1 + 1*(0+1)=12
	// 1*10 + 1*(3+1)=14
	// 0*100 + 1*(13+1)=14

	// 1 3
	// 1*1 + 1*(0+1)=2
	// 0*10 + 1*(3+1)=4

	// 2 0 0
	// 20*1 + 1*(0+0) = 20
	// 2*10 + 1*(0+0) = 20
	// 1*100

	public int countDigitOne(int n) {
		if (n < 0) {
			return 0;
		}
		int res = 0;
		String s = Integer.toString(n);
		int unit = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			String st = s.substring(0, i);
			String mid = s.substring(i, i + 1);
			String end = s.substring(i + 1);
			res += compute(st, mid, end, unit);
			unit *= 10;
		}

		return res;
	}

	private int compute(String st, String mid, String end, int unit) {
		int a = (st.isEmpty()) ? 0 : Integer.parseInt(st);
		int b = Integer.parseInt(mid);
		int c = (end.isEmpty()) ? 0 : Integer.parseInt(end);

		int res;
		if (b > 0) {
			if (b == 1) {
				res = a * unit + c + 1;
			} else {
				res = (a + 1) * unit;
			}
		} else {
			res = a * unit;
		}
		return res;
	}

	@Test
	public void test() {
		System.out.println(countDigitOne(-1));
		System.out.println(countDigitOne(0));
		System.out.println(countDigitOne(1));
		System.out.println(countDigitOne(3));
		System.out.println(countDigitOne(13));
		System.out.println(countDigitOne(113));
		System.out.println(countDigitOne(199));
		System.out.println(countDigitOne(200));
		System.out.println(countDigitOne(205));
		System.out.println(countDigitOne(300));
		System.out.println(countDigitOne(310));
	}


}
