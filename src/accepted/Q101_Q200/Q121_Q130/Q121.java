package accepted.Q101_Q200.Q121_Q130;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q121 {

	public int maxProfit(int[] prices) {

		if (prices.length < 2) {
			return 0;
		}

		int res = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - min > res) {
				res = prices[i] - min;
			}
			if (prices[i] < min) {
				min = prices[i];
			}
		}

		return res;
	}

	@Test
	public void test() {
		int[] a = { 3, 5, 4, 8, 1, 7 };
		assertEquals(6, maxProfit(a));

		int[] b = { 8, 6, 3, 2 };
		assertEquals(0, maxProfit(b));
	}

}
