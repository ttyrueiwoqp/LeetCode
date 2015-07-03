package accepted.Q011_Q020;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Q013 {

	/**
	 * I - 1 V - 5
	 * <p>
	 * X - 10 L - 50
	 * <p>
	 * C - 100 D - 500
	 * <p>
	 * M - 1000
	 */
	public int romanToInt(String s) {

		int res = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
				case 'I':
					res += 1;
					break;
				case 'V':
					res += 5;
					if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
						res -= 1;
						i--;
					}
					break;
				case 'X':
					res += 10;
					if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
						res -= 1;
						i--;
					}
					break;
				case 'L':
					res += 50;
					if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
						res -= 10;
						i--;
					}
					break;
				case 'C':
					res += 100;
					if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
						res -= 10;
						i--;
					}
					break;
				case 'D':
					res += 500;
					if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
						res -= 100;
						i--;
					}
					break;
				case 'M':
					res += 1000;
					if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
						res -= 100;
						i--;
					}
					break;
				default:
					break;
			}
		}

		return res;
	}

	@Test
	public void test() {

		assertEquals(1000, romanToInt("M"));
		assertEquals(2000, romanToInt("MM"));
		assertEquals(3000, romanToInt("MMM"));

		assertEquals(1100, romanToInt("MC"));
		assertEquals(2400, romanToInt("MMCD"));
		assertEquals(3500, romanToInt("MMMD"));
		assertEquals(3900, romanToInt("MMMCM"));

		assertEquals(1066, romanToInt("MLXVI"));
		assertEquals(207, romanToInt("CCVII"));
		assertEquals(1954, romanToInt("MCMLIV"));
		assertEquals(1990, romanToInt("MCMXC"));
		assertEquals(2014, romanToInt("MMXIV"));
	}
}
