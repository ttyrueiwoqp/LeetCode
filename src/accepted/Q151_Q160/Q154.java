package accepted.Q151_Q160;

import org.junit.Test;

/**
 * Created by LU-PC on 7/3/2015.
 * <p>
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 */
public class Q154 {

	public int findMin(int[] num) {
		return checkMin(num, 0, num.length - 1);
	}

	public int checkMin(int[] num, int st, int end) {
		int mid = (st + end) / 2;

		if (st == mid) {
			return num[st] < num[end] ? num[st] : num[end];
		}

		if (num[mid] < num[end]) {
			return checkMin(num, st, mid);
		} else if (num[mid] > num[end]) {
			return checkMin(num, mid, end);
		} else {
			return checkMin(num, st, end - 1);
		}
	}

	@Test
	public void test() {
		int[] a = {1,0,1,1,1};
		System.out.println(findMin(a));
	}
}
