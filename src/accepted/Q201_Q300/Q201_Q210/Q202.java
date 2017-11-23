package accepted.Q201_Q300.Q201_Q210;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 5/28/2015.
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Q202 {

	public boolean isHappy(int n) {
		List<Integer> m = new ArrayList<>();
		while (!m.contains(n)) {
			m.add(n);
			n = getNextSum(n);
			if (n == 1) {
				return true;
			}
		}
		return false;
	}

	private int getNextSum(int n) {
		int res = 0;
		while (n > 0) {
			res += (n % 10) * (n % 10);
			n = n / 10;
		}
		return res;
	}

	@Test
	public void test() {
		System.out.println(isHappy(29));
		System.out.println(isHappy(7));
	}
}
