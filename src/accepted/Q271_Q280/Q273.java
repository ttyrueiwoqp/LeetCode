package accepted.Q271_Q280;

import org.junit.Test;

/**
 * Created by LU-PC on 10/8/2015.
 * <p>
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 2^31 - 1.
 * <p>
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class Q273 {
	public String numberToWords(int num) {

		if (num == 0) {
			return "Zero";
		}

		String[] s = {"", "Thousand", "Million", "Billion"};
		StringBuilder sb = new StringBuilder();

		int sIdx = 0;
		do {
			int reminder = num % 1000;
			if (reminder > 0) {
				sb.insert(0, convertXXX(reminder) + s[sIdx] + " ");
			}
			sIdx++;
		} while ((num = num / 1000) > 0 && sIdx < s.length);

		return sb.toString().trim();
	}

	private String convertXXX(int xxx) {

		String[] arrX = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		String[] arrX0 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String[] arr1X = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen",""};

		StringBuilder sb = new StringBuilder();

		if (xxx / 100 > 0) {
			sb.append(arrX[xxx / 100]).append(" ");
			sb.append("Hundred");
			if (xxx % 100 > 0) {
				sb.append(" ");
			}
		}
		int xx = xxx % 100;
		if (xx >= 10 && xx < 20) {
			sb.append(arr1X[xx % 10]).append(" ");
		} else {
			if (xx >= 20) {
				sb.append(arrX0[xx / 10]);
				if (xx % 10 > 0) {
					sb.append(" ");
				}
			}
			sb.append(arrX[xx % 10]).append(" ");
		}

		return sb.toString();
	}

	@Test
	public void test() {
		System.out.println(numberToWords(100000));
		System.out.println(numberToWords(123));
		System.out.println(numberToWords(12345));
		System.out.println(numberToWords(1234567));
		System.out.println(numberToWords(50868));
	}
}
