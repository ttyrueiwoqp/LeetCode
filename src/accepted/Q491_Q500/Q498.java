package accepted.Q491_Q500;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal
 * order as shown in the below image.
 * <p>
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * <p>
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class Q498 {

    public int[] findDiagonalOrder(int[][] matrix) {

        int h = matrix.length;
        if (h == 0) {
            return new int[0];
        }
        int w = matrix[0].length;
        int[] res = new int[w * h];

        int i = 0, j = 0, d = 1, k = 0;
        res[k++] = matrix[i][j];

        while (k < w * h) {
            while (i - d >= 0 && i - d < h && j + d >= 0 && j + d < w) {
                i -= d;
                j += d;
                res[k++] = matrix[i][j];
            }

            if (k == w * h) {
                break;
            }

            if (d == 1) {
                if (j + 1 < w) {
                    res[k++] = matrix[i][++j];
                } else {
                    res[k++] = matrix[++i][j];
                }
            } else {
                if (i + 1 < h) {
                    res[k++] = matrix[++i][j];
                } else {
                    res[k++] = matrix[i][++j];
                }
            }
            d = -d;
        }

        return res;
    }
}
