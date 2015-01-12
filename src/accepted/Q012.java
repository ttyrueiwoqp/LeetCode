package accepted;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q012 {

	/**
	 * I - 1 V - 5
	 * 
	 * X - 10 L - 50
	 * 
	 * C - 100 D - 500
	 * 
	 * M - 1000
	 */
	public String intToRoman(int num) {

		String res = "";

		int digit = num / 1000;
		for (int i = 0; i < digit; i++) {
			res += "M";
		}

		digit = num / 100 % 10;
		res += convDigit(digit, "C", "D", "M");

		digit = num / 10 % 10;
		res += convDigit(digit, "X", "L", "C");

		digit = num % 10;
		res += convDigit(digit, "I", "V", "X");

		return res;
	}

	private String convDigit(int digit, String one, String five, String ten) {

		String res = new String();

		switch (digit) {
		case 0:
		case 1:
		case 2:
		case 3:
			for (int i = 0; i < digit; i++) {
				res += one;
			}
			break;
		case 4:
			res += one + five;
			break;
		case 5:
			res += five;
			break;
		case 6:
		case 7:
		case 8:
			res += five;
			for (int i = 0; i < digit - 5; i++) {
				res += one;
			}
			break;
		case 9:
			res += one + ten;
			break;
		default:
			break;
		}

		return res;
	}

	@Test
	public void test() {

		assertEquals("M", intToRoman(1000));
		assertEquals("MM", intToRoman(2000));
		assertEquals("MMM", intToRoman(3000));

		assertEquals("MC", intToRoman(1100));
		assertEquals("MMCD", intToRoman(2400));
		assertEquals("MMMD", intToRoman(3500));
		assertEquals("MMMCM", intToRoman(3900));

		assertEquals("MLXVI", intToRoman(1066));
		assertEquals("CCVII", intToRoman(207));
		assertEquals("MCMLIV", intToRoman(1954));
		assertEquals("MCMXC", intToRoman(1990));
		assertEquals("MMXIV", intToRoman(2014));

	}

}
