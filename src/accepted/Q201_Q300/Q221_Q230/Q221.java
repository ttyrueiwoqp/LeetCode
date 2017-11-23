package accepted.Q201_Q300.Q221_Q230;

import org.junit.Test;

/**
 * Created by FJ on 6/21/2015.
 * <p/>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * <p/>
 * For example, given the following matrix:
 * <p/>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class Q221 {
	public int maximalSquare(char[][] matrix) {
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int curr = matrix[i][j];
				if (curr == '1') {
					max = Math.max(max, findArea(matrix, i, j));
				}
			}
		}
		return max;
	}

	private int findArea(char[][] matrix, int i, int j) {
		int k = 1;
		while (i + k < matrix.length && j + k < matrix[i].length) {
			for (int m = i; m <= i + k; m++) {
				if (matrix[m][j + k] == '0') {
					return k * k;
				}
			}
			for (int n = j; n <= j + k; n++) {
				if (matrix[i + k][n] == '0') {
					return k * k;
				}
			}
			k++;
		}
		return k * k;
	}

	@Test
	public void test() {
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '1', '0', '0'}};

		System.out.println(maximalSquare(matrix));

		char[][] matrix2 = {{'1'}};

		System.out.println(maximalSquare(matrix2));
	}


}
