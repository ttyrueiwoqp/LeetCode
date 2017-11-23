package accepted.Q101_Q200.Q181_Q190;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by LU-PC on 5/28/2015.
 * <p>
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class Q189 {
	public void rotate(int[] nums, int k) {
		int[] res = new int[nums.length];
		k = k % nums.length;
		for (int num : nums) {
			if (k == res.length) {
				k = 0;
			}
			res[k] = num;
			k++;
		}
		System.arraycopy(res, 0, nums, 0, res.length);
	}

	@Test
	public void test() {
		int[] nums = {1, 2};
		rotate(nums, 3);
		System.out.println(Arrays.toString(nums));

		int[] nums2 = {1,2,3,4,5,6,7};
		rotate(nums2, 3);
		System.out.println(Arrays.toString(nums2));
	}
}
