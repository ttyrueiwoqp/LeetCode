package accepted.Q161_Q170;

import org.junit.Test;

/**
 * Created by FJ on 6/20/2015.
 * <p/>
 * A peak element is an element that is greater than its neighbors.
 * <p/>
 * Given an input array where num[i] ? num[i+1], find a peak element and return its index.
 * <p/>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p/>
 * You may imagine that num[-1] = num[n] = -?.
 * <p/>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * <p/>
 * click to show spoilers.
 * <p/>
 * Note:
 * Your solution should be in logarithmic complexity.
 */
public class Q162 {
	public int findPeakElement(int[] nums) {
		return binarySearch(nums, 0, nums.length - 1);
	}

	private int binarySearch(int[] nums, int stIdx, int endIdx) {
		int midIdx = (stIdx + endIdx) / 2;

		int curr = nums[midIdx];

		if (midIdx > 0 && nums[midIdx - 1] > curr) {
			return binarySearch(nums, stIdx, midIdx - 1);
		} else if (midIdx < nums.length - 1 && nums[midIdx + 1] > curr) {
			return binarySearch(nums, midIdx + 1, endIdx);
		} else {
			return midIdx;
		}
	}

	@Test
	public void test() {
		int a[] = {1, 2, 3, 1};
		System.out.println(findPeakElement(a));
	}
}
