package accepted.Q601_Q700.Q661_Q670;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray
 * scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */
public class Q661 {
    public int[][] imageSmoother(int[][] M) {
        int h = M.length, w = M[0].length;
        int[][] s = new int[h][w];
        int[] dir = {-1, 0, 1};

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int count = 0;

                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (i + dir[m] >= 0 && i + dir[m] < h
                                && j + dir[n] >= 0 && j + dir[n] < w) {

                            s[i][j] += M[i + dir[m]][j + dir[n]];
                            count++;
                        }
                    }
                }

                s[i][j] /= count;
            }
        }

        return s;
    }
}
