package accepted.Q001_Q100.Q051_Q060;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Determine if you are able to reach the last index.
 * <p/>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p/>
 * A = [3,2,1,0,4], return false.
 */
public class Q055 {

	public boolean canJump1(int[] A) {
		return jump(A, 0);
	}

	private boolean jump(int[] A, int idx) {

		for (int j = 1; j < A[idx]; j++) {
			if (idx + j + A[idx + j] >= A.length - 1) {
				return true;
			} else if (jump(A, idx + j)) {
				return true;
			}
		}
		return false;
	}

	public boolean canJump(int[] A) {

		int[] max = new int[A.length];
		max[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			if (i > max[i - 1]) {
				return false;
			}
			max[i] = Math.max(i + A[i], max[i - 1]);
		}

		return true;
	}

	@Test
	public void test() {
		int[] a = {2, 3, 1, 1, 4};
		assertTrue(canJump(a));

		int[] b = {3, 2, 1, 0, 4};
		assertFalse(canJump(b));
	}

}
