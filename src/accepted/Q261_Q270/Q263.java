package accepted.Q261_Q270;

import org.junit.Test;

/**
 * Created by LU-PC on 10/8/2015.
 * <p>
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 */
public class Q263 {

	public boolean isUgly(int num) {

		if (num < 1) {
			return false;
		}

		num = divideBy(num, 2);
		num = divideBy(num, 3);
		num = divideBy(num, 5);

		return num == 1;
	}

	public int divideBy(int num, int d) {
		while (num % d == 0) {
			num = num / d;
		}
		return num;
	}

	@Test
	public void test() {
		System.out.println(isUgly(6));
		System.out.println(isUgly(8));
		System.out.println(isUgly(14));
		System.out.println(isUgly(1));
	}
}
