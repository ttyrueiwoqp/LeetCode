package accepted.Q001_Q100.Q021_Q030;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a sorted array, remove the duplicates in place
 * such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array,
 * you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2,
 * with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class Q026 {

	public int removeDuplicates(int[] A) {

		if (A.length < 2) {
			return A.length;
		}

		int p = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				A[p] = A[i];
				p++;
			}
		}

		return p;
	}

	@Test
	public void test() {
		int[] a = {1, 1, 2, 2, 3, 4, 4, 5};
		assertEquals(5, removeDuplicates(a));
	}

}
