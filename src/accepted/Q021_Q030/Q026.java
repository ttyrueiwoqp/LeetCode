package accepted.Q021_Q030;

import static org.junit.Assert.*;

import org.junit.Test;

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
		int[] a = { 1, 1, 2, 2, 3, 4, 4, 5 };
		assertEquals(5, removeDuplicates(a));
	}

}
