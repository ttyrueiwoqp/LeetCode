package accepted.Q201_Q300.Q231_Q240;

/**
 * Created by LU-PC on 10/20/2015.
 * <p>
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity?
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Q238 {
	public int[] productExceptSelf(int[] nums) {

		int[] a = new int[nums.length];
		int[] b = new int[nums.length];
		a[0] = 1;
		b[nums.length - 1] = 1;

		for (int i = 1; i < nums.length; i++) {
			a[i] = a[i-1] * nums[i-1];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			b[i] = b[i+1] * nums[i+1];
		}

		for (int i = 0; i < nums.length; i++) {
			a[i] = a[i] * b[i];
		}
		return a;
	}
}
