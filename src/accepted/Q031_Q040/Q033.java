package accepted.Q031_Q040;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search.
 * If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class Q033 {
	public int search(int[] A, int target) {
		return binarySearch(A, 0, A.length - 1, target);
	}

	private int binarySearch(int[] A, int stIdx, int endIdx, int target) {
		int midIdx = (stIdx + endIdx) / 2;
		if (target == A[stIdx]) {
			return stIdx;
		}
		if (target == A[midIdx]) {
			return midIdx;
		}
		if (target == A[endIdx]) {
			return endIdx;
		}
		if (stIdx == endIdx) {
			return -1;
		}
		if (A[stIdx] < A[midIdx]) {
			return target > A[stIdx] && target < A[midIdx] ?
					binarySearch(A, stIdx, midIdx, target) : binarySearch(A, midIdx + 1, endIdx, target);
		} else {
			return target > A[stIdx] || target < A[midIdx] ?
					binarySearch(A, stIdx, midIdx, target) : binarySearch(A, midIdx + 1, endIdx, target);
		}
	}

	@Test
	public void test() {
		int[] a = {4, 5, 6, 7, 0, 1, 2};
		search(a, 2);
		for (int i = 0; i < 8; i++) {
			System.out.println(search(a, i));
		}
	}

}
