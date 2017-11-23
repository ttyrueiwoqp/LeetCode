package accepted.Q501_Q600.Q541_Q550;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * Example 1:
 * Input:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Output:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Example 2:
 * Input:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * Output:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class Q542 {

    public int[][] updateMatrix(int[][] matrix) {
        int h = matrix.length, w = matrix[0].length;
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            for (int[] d : dirs) {
                int r = p[0] + d[0];
                int c = p[1] + d[1];
                if (r < 0 || r >= h || c < 0 || c >= w ||
                        matrix[r][c] <= matrix[p[0]][p[1]] + 1) {
                    continue;
                }
                queue.offer(new int[] {r, c});
                matrix[r][c] = matrix[p[0]][p[1]] + 1;
            }
        }

        return matrix;
    }
}
