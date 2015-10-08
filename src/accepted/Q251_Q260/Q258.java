package accepted.Q251_Q260;

import org.junit.Test;

/**
 * Created by LU-PC on 10/8/2015.
 * <p>
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class Q258 {

	public int addDigits(int num) {
		return num % 9 == 0 ? (num == 0 ? 0 : 9) : num % 9;
	}

	@Test
	public void test() {
		System.out.println(addDigits(38));
	}
}
