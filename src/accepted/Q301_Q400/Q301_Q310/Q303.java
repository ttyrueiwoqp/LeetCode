package accepted.Q301_Q400.Q301_Q310;

/**
 * Created by FJ on 11/12/2015.
 * <p/>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p/>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p/>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class Q303 {

	private int[] sums;

	public Q303(int[] nums) {
		if (nums.length > 0) {
			sums = new int[nums.length];
			sums[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sums[i] = sums[i - 1] + nums[i];
			}
		}
	}

	public int sumRange(int i, int j) {
		return i == 0 ? sums[j] : sums[j] - sums[i - 1];
	}

}
