package accepted.Q301_Q400.Q321_Q330;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by FJ on 1/24/2016.
 * <p/>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up
 * that amount. If that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * <p/>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p/>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p/>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Q322 {

	public int coinChange(int[] coins, int amount) {
		int len = amount + 1;
		int[] res = new int[len];

		Arrays.sort(coins);

		for (int i = 1; i < len; i++) {
			res[i] = Integer.MAX_VALUE;
			boolean found = false;
			for (int j = coins.length - 1; j >= 0; j--) {
				if (i - coins[j] >= 0 && res[i - coins[j]] > -1) {
					res[i] = Integer.min(res[i - coins[j]] + 1, res[i]);
					found = true;
				}
			}
			if (!found) {
				res[i] = -1;
			}
		}

		return res[amount];
	}

	@Test
	public void test() {
//		int[] a = new int[]{1, 2, 5};
//		int[] b = new int[]{2};
		int[] c = new int[]{186,419,83,408};
//		System.out.println(coinChange(a, 11));
//		System.out.println(coinChange(b, 3));
		System.out.println(coinChange(c, 6249));
	}
}
