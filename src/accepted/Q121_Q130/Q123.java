package accepted.Q121_Q130;

import org.junit.Test;

/**
 * Created by FJ on 3/12/2016.
 * <p/>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p/>
 * Note:
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */
public class Q123 {

	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}

		int res = 0;
		int[] left = maxProfitsFromLeft(prices);
		int[] right = maxProfitsFromRight(prices);

		for (int i = 0; i < prices.length - 1; i++) {
			res = Math.max(res, left[i] + right[i + 1]);
		}
		res = Math.max(res, right[0]);
		res = Math.max(res, left[prices.length - 1]);

		return res;
	}

	public int[] maxProfitsFromLeft(int[] prices) {
		int len = prices.length;
		int[] res = new int[len];
		if (len < 2) {
			return res;
		}

		res[0] = 0;
		int min = prices[0];
		for (int i = 1; i < len; i++) {
			res[i] = Math.max(prices[i] - min, res[i - 1]);
			min = Math.min(prices[i], min);
		}

		return res;
	}

	public int[] maxProfitsFromRight(int[] prices) {
		int len = prices.length;
		int[] res = new int[len];
		if (len < 2) {
			return res;
		}

		res[len - 1] = 0;
		int max = prices[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			res[i] = Math.max(max - prices[i], res[i + 1]);
			max = Math.max(prices[i], max);
		}

		return res;
	}


	@Test
	public void test() {
		int[] a = {2,1,2,0,1};
		System.out.println(maxProfit(a));
	}
}
