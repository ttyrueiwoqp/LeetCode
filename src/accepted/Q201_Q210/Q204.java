package accepted.Q201_Q210;

import org.junit.Test;

/**
 * Created by LU-PC on 7/6/2015.
 * <p>
 * Description:
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Let's start with a isPrime function. To determine if a number is prime,
 * we need to check if it is not divisible by any number less than n.
 * The runtime complexity of isPrime function would be O(n)
 * and hence counting the total prime numbers up to n would be O(n2).
 * Could we do better?
 */
public class Q204 {
	public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}

		int res = n - 2, i = 2;
		int[] nums = new int[n];
		Double sqrt = Math.sqrt(n);
		while (i <= sqrt.intValue()) {
			int j = 2;
			while (i * j < n) {
				nums[i * j] = 1;
				j++;
			}
			do {
				i++;
			} while (nums[i] == 1);
		}

		for (int num : nums) {
			res -= num;
		}

		return res;
	}

	@Test
	public void test() {
		System.out.println(countPrimes(6));
	}
}
