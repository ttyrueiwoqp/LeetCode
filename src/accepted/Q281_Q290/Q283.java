package accepted.Q281_Q290;

import org.junit.Test;

/**
 * Created by LU-PC on 10/8/2015.
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Q283 {
	public void moveZeroes(int[] nums) {
		int p0 = -1, p = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (p0 == -1) {
					p0 = i;
				}
			} else {
				p = i;
			}

			if (p > p0 && p0 > -1) {
				swap(nums, p0, p);
				while (p0 <= p && nums[p0] != 0) {
					p0++;
				}
				p = -1;
			}
		}
	}

	private void swap(int[] nums, int p0, int p) {
		int temp = nums[p0];
		nums[p0] = nums[p];
		nums[p] = temp;
	}

	@Test
	public void test() {
		int[] a = {1, 3, 12, 0, 0};
		moveZeroes(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
