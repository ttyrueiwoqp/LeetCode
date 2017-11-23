package accepted.Q001_Q100.Q031_Q040;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Q034 {

	public int[] searchRange(int[] A, int target) {

		int[] res = new int[2];

		res[0] = binarySearch(A, 0, A.length - 1, target - 0.5, -0.5);
		res[1] = binarySearch(A, 0, A.length - 1, target + 0.5, 0.5);
		return res;
	}

	public int binarySearch(int[] A, int st, int end, double target,
			double offset) {

		if (st >= end) {
			if (target == A[st] + offset) {
				return st; 
			} else if (st - 1 >= 0 && target == A[st - 1] + offset) {
				return st - 1;
			} else if (st + 1 < A.length && target == A[st + 1] + offset) {
				return st + 1;
			} else {
				return -1;
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

		int[] A = { 1, 2, 3 };
		int[] B = { 1, 1 };
		assertArrayEquals(B, searchRange(A, 2));
	}

}
