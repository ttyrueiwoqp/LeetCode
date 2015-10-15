package qns;

import org.junit.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LU-PC on 10/14/2015.
 * <p>
 * Given a positive integer n, find the least number of
 * perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
 * given n = 13, return 2 because 13 = 4 + 9.
 */
public class Q279 {
	public int numSquares(int n) {
		int res = 0;
		while (n > 0) {
			n -= closetSquare(n);
			res++;
		}
		return res;
	}

	private int closetSquare(int n) {
		int sqrt = sqrt(n);
		return sqrt * sqrt;
	}

	private int sqrt(int x) {
		int g1 = x;
		int g2 = iter(g1, x);
		while (x / g1 < g1) {
			g1 = g2;
			g2 = iter(g2, x);
		}
		return g1;
	}

	private int iter(int g, int x) {
		return (g + x / g) / 2;
	}

	@Test
	public void test() {

	}
}
