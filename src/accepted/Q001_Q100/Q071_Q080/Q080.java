package accepted.Q001_Q100.Q071_Q080;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by LU-PC on 6/3/2015.
 * <p>
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 */
public class Q080 {
	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}

		int p = 1;
		boolean pass = true;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				pass = true;
				nums[p] = nums[i];
				p++;
			} else if (pass) {
				pass = false;
				nums[p] = nums[i];
				p++;
			}
		}
		return p;
	}

	@Test
	public void test() {
		int[] a = {1, 1, 1, 2, 2, 3};
		assertEquals(5, removeDuplicates(a));
	}
}
