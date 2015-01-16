package accepted.Q061_Q070;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q070 {

	public int climbStairs(int n) {

		if (n < 1) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}

		int[] ways = new int[n];
		ways[0] = 0;
		ways[1] = 1;
		ways[2] = 2;

		for (int i = 3; i < n; i++) {
			ways[i] = ways[i - 1] + ways[i - 2];
		}
		return ways[n - 2] + ways[n - 1];
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
