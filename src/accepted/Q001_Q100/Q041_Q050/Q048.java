package accepted.Q001_Q100.Q041_Q050;

import org.junit.Test;

/**
 * Created by LU-PC on 6/3/2015.
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 */
public class Q048 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int size1 = n / 2 + n % 2;
		int size2 = n / 2;
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}

	@Test
	public void test() {

		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}



	}
}
