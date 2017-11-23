package accepted.Q201_Q300.Q261_Q270;

import org.junit.Test;

/**
 * Created by FJ on 10/10/2015.
 * <p/>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * <p/>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p/>
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 */
public class Q268 {

	public int missingNumber(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return nums.length * (nums.length + 1) / 2 - sum ;
	}

	@Test
	public void test() {
		int[] a = {1, 0, 3};
		System.out.println(missingNumber(a));
	}
}
