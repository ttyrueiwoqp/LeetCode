package accepted.Q211_Q220;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by LU-PC on 6/3/2015.
 * <p>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ? k ? array's length.
 */
public class Q215 {
	/**
	 * Easier solution exists when modify the pivot of quick sort.
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
