package accepted.Q301_Q400.Q311_Q320;

import org.junit.Test;

/**
 * Created by FJ on 12/5/2015.
 * <p/>
 * Write a program to find the nth super ugly number.
 * <p/>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given
 * primes = [2, 7, 13, 19] of size 4.
 * <p/>
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */
public class Q313 {

	public int nthSuperUglyNumber(int n, int[] primes) {

		int[] idxs = new int[primes.length];
		int[] res = new int[n];
		res[0] = 1;

		int count = 1;
		while (count < n) {
			int curr = Integer.MAX_VALUE;
			for (int i = 0; i < primes.length; i++) {
				curr = Math.min(curr, res[idxs[i]] * primes[i]);
			}
			res[count] = curr;
			for (int i = 0; i < primes.length; i++) {
				if (curr == res[idxs[i]] * primes[i]) {
					idxs[i]++;
				}
			}
			count++;
		}
		return res[n - 1];
	}

	@Test
	public void test() {
		int[] a = {2, 7, 13, 19};

		System.out.println(nthSuperUglyNumber(4, a));

		for (int i = 1; i <= 12; i++) {
			System.out.println(nthSuperUglyNumber(i, a));
		}

		int[] b = {7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181, 199, 211, 229, 233, 239, 241, 251};
		System.out.println(nthSuperUglyNumber(10000, b));
	}
}
