package accepted.Q701_Q800.Q761_Q770;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * <p>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * Explanation:
 * 1234
 * 5123
 * 9512
 * <p>
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
 * Example 2:
 * <p>
 * Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * Note:
 * <p>
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 */
public class Q766 {

    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int n = matrix[i][0];
            for (int j = 1; i + j < matrix.length && j < matrix[0].length; j++) {
                if (matrix[i + j][j] != n) {
                    return false;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int n = matrix[0][j];
            for (int i = 1; i < matrix.length && i + j < matrix[0].length; i++) {
                if (matrix[i][i + j] != n) {
                    return false;
                }
            }
        }

        return true;
    }
}
