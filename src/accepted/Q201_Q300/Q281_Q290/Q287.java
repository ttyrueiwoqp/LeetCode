package accepted.Q201_Q300.Q281_Q290;

/**
 * Created by FJ on 12/5/2015.
 * <p/>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 * <p/>
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Q287 {

	public int findDuplicate(int[] nums) {

		int i = 0, j = 0, k = 0;
		do {
			i = nums[i];
			j = nums[nums[j]];
		} while (i != j);

		i = nums[i];
		while (i != k) {
			i = (i == j) ? 0 : nums[i];
			k = nums[k];
		}

		return i;
	}
}
