package accepted.Q101_Q200.Q161_Q170;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LU-PC on 6/9/2015.
 * <p>
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class Q166 {
	public String fractionToDecimal(int numerator, int denominator) {
		int sign = 1;
		long n = numerator, d = denominator;
		if (numerator < 0) {
			n = -1L * numerator;
			sign = -sign;
		}
		if (denominator < 0 && numerator != 0) {
			d = -1L * denominator;
			sign = -sign;
		}

		long quotient = n / d;
		long remainder = n % d;

		if (remainder == 0) {
			return (sign == 1 ? "" : "-") + String.valueOf(quotient);
		}

		String res = quotient + ".";
		Map<Long, Integer> m = new HashMap<>();

		while (remainder != 0) {
			remainder *= 10;
			if (m.containsKey(remainder)) {
				int idx = m.get(remainder);
				res = res.substring(0, idx) + "(" + res.substring(idx) + ")";
				break;
			}
			m.put(remainder, res.length());
			res += String.valueOf(remainder / d);
			remainder = remainder % d;
		}

		return (sign == 1 ? "" : "-") + res;
	}

	@Test
	public void test() {
		System.out.println(fractionToDecimal(0, -5));

	}

}
