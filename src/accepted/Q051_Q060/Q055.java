package accepted.Q051_Q060;

import static org.junit.Assert.*;

import org.junit.Test;

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
		int[] a = { 2, 3, 1, 1, 4 };
		assertTrue(canJump(a));

		int[] b = { 3, 2, 1, 0, 4 };
		assertFalse(canJump(b));
	}

}
