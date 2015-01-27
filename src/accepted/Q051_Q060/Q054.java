package accepted.Q051_Q060;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q054 {

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null) {
			return res;
		}

		int h = matrix.length;
		if (h == 0) {
			return res;
		}
		int w = matrix[0].length;
		int idx = 0;
		int min = Math.min(w, h);

		while (idx * 2 < min) {
			for (int j = idx; j < w - idx; j++) {
				res.add(matrix[idx][j]);
			}
			for (int i = idx + 1; i < h - idx; i++) {
				res.add(matrix[i][w - 1 - idx]);
			}
			if (idx == h - 1 - idx || idx == w - 1 - idx) {
				break;
			}
			for (int j = w - 2 - idx; j >= idx; j--) {
				res.add(matrix[h - 1 - idx][j]);
			}
			for (int i = h - 2 - idx; i > idx; i--) {
				res.add(matrix[i][idx]);
			}
			idx++;
		}

		return res;
	}

	@Test
	public void test() {

		int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		System.out.println(spiralOrder(m));

		int[][] n = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };
		System.out.println(spiralOrder(n));

		int[][] f = { { 7 }, { 9 }, { 6 }, { 1 }, { 2 }, { 3 } };
		System.out.println(spiralOrder(f));
	}

}
