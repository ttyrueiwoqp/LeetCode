package accepted.Q321_Q330;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by FJ on 2/8/2016.
 * <p/>
 * Given a sorted positive integer array nums and an integer n,
 * add/patch elements to the array such that any number in range [1, n] inclusive can be formed
 * by the sum of some elements in the array. Return the minimum number of patches required.
 * <p/>
 * Example 1:
 * nums = [1, 3], n = 6
 * Return 1.
 * <p/>
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * <p/>
 * Example 2:
 * nums = [1, 5, 10], n = 20
 * Return 2.
 * The two patches can be [2, 4].
 * <p/>
 * Example 3:
 * nums = [1, 2, 2], n = 5
 * Return 0.
 */
public class Q330 {

	public int minPatches(int[] nums, int n) {
		int miss = 1, res = 0, i = 0;

		while (miss <= n) {
			if (i < nums.length && nums[i] <= miss) {
				miss += nums[i];
				i++;
			} else {
				miss += miss;
				res++;
			}
		}

		return res;
	}

	@Test
	public void test() {

		int[] a = {1, 3};
		int[] b = {1, 5, 10};
		int[] c = {1, 2, 2};
		int[] d = {1, 2, 31, 33};
		assertEquals(1, minPatches(a, 6));
		assertEquals(2, minPatches(b, 20));
		assertEquals(0, minPatches(c, 5));

		System.out.println(minPatches(d, 2147483));
	}
}
