package accepted.Q081_Q090;

import org.junit.Test;

/**
 * Created by LU-PC on 7/3/2015.
 * <p>
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * <p>
 * Write a function to determine if a given target is in the array.
 */
public class Q081 {
	public boolean search(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length - 1, target);
	}

	private boolean binarySearch(int[] A, int stIdx, int endIdx, int target) {
		int midIdx = (stIdx + endIdx) / 2;
		if (target == A[stIdx] || target == A[midIdx] || target == A[endIdx]) {
			return true;
		}
		if (stIdx == endIdx) {
			return false;
		}
		if (A[stIdx] < A[midIdx]) {
			return target > A[stIdx] && target < A[midIdx] ?
					binarySearch(A, stIdx, midIdx, target) : binarySearch(A, midIdx + 1, endIdx, target);
		} else if (A[stIdx] > A[midIdx]) {
			return target > A[stIdx] || target < A[midIdx] ?
					binarySearch(A, stIdx, midIdx, target) : binarySearch(A, midIdx + 1, endIdx, target);
		} else {
			return binarySearch(A, stIdx, midIdx, target) || binarySearch(A, midIdx + 1, endIdx, target);
		}
	}

	@Test
	public void test() {
		int[] a = {1, 3, 1, 1, 1};
		System.out.println(search(a, 3));
	}

}
