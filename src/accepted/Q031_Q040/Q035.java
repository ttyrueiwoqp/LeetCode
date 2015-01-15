package accepted.Q031_Q040;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q035 {

	public int searchInsert(int[] A, int target) {
		
		return binarySearch(A, 0, A.length - 1, target - 0.5, -0.5);
	}

	public int binarySearch(int[] A, int st, int end, double target,
			double offset) {

		if (st >= end) {
			if (target > A[st]) {
				return st + 1;
			} else {
				return st;
			}
		}
		int mid = (st + end) / 2;
		if (target < A[mid]) {
			return binarySearch(A, st, mid - 1, target, offset);
		} else if (target > A[mid]) {
			return binarySearch(A, mid + 1, end, target, offset);
		} else {
			return -1;
		}
	}

	@Test
	public void test() {

		int[] a = { 1, 3, 5, 6 };
		assertEquals(2, searchInsert(a, 5));
		assertEquals(1, searchInsert(a, 2));
		assertEquals(4, searchInsert(a, 7));
		assertEquals(0, searchInsert(a, 0));

	}

}
