package accepted;

import java.util.ArrayList;
import java.util.List;

public class Q027 {
	
	public int removeElement1(int[] A, int elem) {
		List<Integer> a = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				a.add(A[i]);
			}
		}

		A = new int[a.size()];
		for (int i = 0; i < A.length; i++) {
			A[i] = a.get(i);
		}

		return a.size();
	}

	public int removeElement2(int[] A, int elem) {
		int len = A.length;
		for (int i = 0; i < len; ++i) {
			while (A[i] == elem && i < len) {
				A[i] = A[--len];
			}
		}
		return len;
	}
	
}
