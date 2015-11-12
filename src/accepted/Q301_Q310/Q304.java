package accepted.Q301_Q310;

/**
 * Created by FJ on 11/12/2015.
 * <p/>
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
 * by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * <p/>
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1)
 * and (row2, col2) = (4, 3), which contains sum = 8.
 * <p/>
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p/>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class Q304 {

	int[][] sums;

	public Q304(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		}
		int width = matrix.length + 1;
		int height = matrix[0].length + 1;
		sums = new int[width][height];
		for (int i = 1; i < width; i++) {
			for (int j = 1; j < height; j++) {
				sums[i][j] += matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		row2++;
		col2++;
		return sums[row2][col2] - sums[row1][col2] - sums[row2][col1] + sums[row1][col1];
	}

	public static void main() {
		int[][] matrix = {{-1}};
		Q304 q = new Q304(matrix);
		System.out.println(q.sumRegion(0, 0, 0, 0));
	}
}
