package accepted.Q101_Q200.Q121_Q130;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q122 {

	public int maxProfit(int[] prices) {

		if (prices.length < 2) {
			return 0;
		}
		
		int sum = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				sum += prices[i - 1] - min;
				min = prices[i];
			}
		}
		
		sum += prices[prices.length - 1] - min;

		return sum;
		
	}

	@Test
	public void test() {
		int[] a = { 3, 5, 4, 8, 1, 7 };
		assertEquals(12, maxProfit(a));
		
		int[] b = { 8, 6, 3, 2 };
		assertEquals(0, maxProfit(b));
	}

}
