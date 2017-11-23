package accepted.Q301_Q400.Q331_Q340;

import org.junit.Test;

/**
 * Created by FJ on 2/28/2016.
 * <p/>
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p/>
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p/>
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * <p/>
 * Given [5, 4, 3, 2, 1],
 * return false.
 */
public class Q334 {

	public boolean increasingTriplet(int[] nums) {

		int len = nums.length;
		if (len < 3) {
			return false;
		}

		int a = nums[0], b = -1;

		int i = 1;
		while (i < len) {
			if (b != -1 && nums[i] > b) {
				return true;
			} else if (nums[i] > a) {
				b = nums[i];
			} else {
				a = nums[i];
			}
			i++;
		}

		return false;
	}

	@Test
	public void test() {
		int[][] a = {
				{1, 2, 3, 4, 5},
				{5, 4, 3, 2, 1},
				{4, 5, 1, 2, 3},
				{4, 5, 1, 2, 0}};

		for (int[] ints : a) {
			System.out.println(increasingTriplet(ints));
		}

	}
}
