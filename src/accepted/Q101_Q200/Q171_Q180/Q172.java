package accepted.Q101_Q200.Q171_Q180;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q172 {

	public int trailingZeroes(int n) {

		int sum = 0;
		int k = 1;
		int limit = Integer.MAX_VALUE / 5;
		while (n >= k && k <= limit) {
			k *= 5;
			sum += n / k;
		}
		return sum;
	}

	public int trailingZeroes2(int n) {

		int c = 0;
		for (; n > 4; c += (n /= 5))
			;
		return c;
	}

	@Test
	public void test() {
		assertEquals(6, trailingZeroes(25));

		System.out.println(1220703125);
		System.out.println(Integer.MAX_VALUE / 5);

		System.out.println(trailingZeroes(1808548325));
		System.out.println(trailingZeroes2(1808548325));

	}

}
