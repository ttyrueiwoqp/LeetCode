package accepted.Q081_Q090;

import org.junit.Test;

public class Q085 {

	public int maximalRectangle(char[][] matrix) {

		int h = matrix.length;
		if (h == 0) {
			return 0;
		}
		int w = matrix[0].length;
		if (w == 0) {
			return 0;
		}

		int[][] x = getX(matrix, h, w);
		int[][] y = getY(matrix, h, w);

		print(x);
		print(y);

		int maxArea = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {

				int xIdx = x[i][j];
				int yIdx = y[i][j];

				int k = 0;
				while (k <= Math.min((xIdx - j), (yIdx - i))
						&& matrix[i + k][j + k] == '1') {

					xIdx = Math.min(xIdx, x[i + k][j + k]);
					yIdx = Math.min(yIdx, y[i + k][j + k]);

					if ((xIdx - j + 1) * (yIdx - i + 1) <= maxArea) {
						break;
					}

					int wArea = (k + 1) * (xIdx - j + 1);
					int hArea = (k + 1) * (yIdx - i + 1);
					if (wArea > maxArea) {
						maxArea = wArea;
					}
					if (hArea > maxArea) {
						maxArea = hArea;
					}

					k++;
				}

				System.out.print(maxArea);
			}
			System.out.println();
		}

		return maxArea;
	}

	private int[][] getX(char[][] matrix, int h, int w) {

		int[][] res = new int[h][w];

		for (int i = h - 1; i >= 0; i--) {
			int curr = -1;
			for (int j = w - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					if (curr == -1) {
						curr = j;
					}

				} else {
					curr = -1;
				}
				res[i][j] = curr;
			}
		}
		return res;
	}

	private int[][] getY(char[][] matrix, int h, int w) {

		int[][] res = new int[h][w];

		for (int j = w - 1; j >= 0; j--) {
			int curr = -1;
			for (int i = h - 1; i >= 0; i--) {
				if (matrix[i][j] == '1') {
					if (curr == -1) {
						curr = i;
					}

				} else {
					curr = -1;
				}
				res[i][j] = curr;
			}
		}
		return res;
	}

	private void print(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	@Test
	public void test() {

		char[][] matrix = { { '0', '1', '1', '0', '1', '1' },
				{ '1', '1', '1', '0', '1', '1' },
				{ '1', '1', '1', '0', '1', '1' },
				{ '1', '1', '1', '0', '1', '1' },
				{ '0', '0', '0', '1', '1', '0' } };
		print(matrix);
		// System.out.println(maximalRectangle(matrix));

		char[][] m2 = { { '1', '0', '1', '0' }, { '1', '0', '1', '1' },
				{ '1', '0', '1', '1' }, { '1', '1', '1', '1' } };
		System.out.println(maximalRectangle(m2));

	}

}
