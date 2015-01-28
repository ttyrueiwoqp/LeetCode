package accepted.Q071_Q080;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q075 {

	public void sortColors(int[] A) {

		int p0 = -1, p1 = -1, p2 = -1;
		for (int i = 0; i < A.length; i++) {

			switch (A[i]) {
			case 0:
				A[++p2] = 2;
				A[++p1] = 1;
				A[++p0] = 0;
				break;
			case 1:
				A[++p2] = 2;
				A[++p1] = 1;
				break;
			case 2:
				A[++p2] = 2;
				break;
			default:
				break;
			}
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
