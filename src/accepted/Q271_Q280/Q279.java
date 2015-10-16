package accepted.Q271_Q280;

import org.junit.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LU-PC on 10/14/2015.
 * <p/>
 * Given a positive integer n, find the least number of
 * perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p/>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
 * given n = 13, return 2 because 13 = 4 + 9.
 */
public class Q279 {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while(i - j*j >= 0) {
				min = Math.min(min, dp[i - j*j] + 1);
				j++;
			}
			dp[i] = min;
		}
		return dp[n];
	}

	@Test
	public void test() {
		System.out.println(numSquares(9975));
	}
}
