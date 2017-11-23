package accepted.Q301_Q400.Q301_Q310;

import org.junit.Test;

/**
 * Created by FJ on 3/12/2016.
 * <p/>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p/>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p/>
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */
public class Q309 {

	public int maxProfit(int[] prices) {
		int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy;
		for (int price : prices) {
			prevBuy = buy;
			buy = Math.max(prevSell - price, prevBuy);
			prevSell = sell;
			sell = Math.max(prevBuy + price, prevSell);
		}
		return sell;
	}

	@Test
	public void test() {
		int[] a = {5,6,4,7};
		System.out.println(maxProfit(a));
	}
}
