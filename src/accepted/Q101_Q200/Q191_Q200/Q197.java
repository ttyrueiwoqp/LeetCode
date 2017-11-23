package accepted.Q101_Q200.Q191_Q200;

import org.junit.Test;

/**
 * Created by LU-PC on 5/28/2015.
 * <p>
 * Write a function that takes an unsigned integer and
 * returns the number of �1' bits it has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer �11' has binary representation 00000000000000000000000000001011,
 * so the function should return 3.
 */
public class Q197 {

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		n = n - ((n >> 1) & 0x55555555);
		n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
		return ((n + (n >> 4) & 0xF0F0F0F) * 0x1010101) >> 24;
	}

	@Test
	public void test() {
		System.out.println(hammingWeight(11));

		int n = 0x02030405;
		System.out.println(Integer.toString(n * 0x01010101, 16));
		// == 0x0e0c0905, >> 24 == 0e
		// 0e == 02 + 03 + 04 + 05
	}

}
