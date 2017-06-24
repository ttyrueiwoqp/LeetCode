package accepted.Q411_Q420;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:
 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.
 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class Q417 {

    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> res = new ArrayList<>();

        int h = matrix.length;
        if (h == 0) {
            return res;
        }
        int w = matrix[0].length;
        if (w == 0) {
            return res;
        }

        int[][] visited = new int[h][w];
        for (int i = 0; i < h; i++) {
            flow(matrix, visited, matrix[i][0], i, 0, 1, res);
            flow(matrix, visited, matrix[i][w - 1], i, w - 1, 2, res);
        }
        for (int j = 0; j < w; j++) {
            flow(matrix, visited, matrix[0][j], 0, j, 1, res);
            flow(matrix, visited, matrix[h - 1][j], h-1, j, 2, res);
        }

        return res;
    }

    private void flow(int[][] matrix, int[][] visited, int src, int i, int j, int k, List<int[]> res) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
                || visited[i][j] == k || visited[i][j] == 3 || matrix[i][j] < src) {
            return;
        }

        visited[i][j] += k;
        if (visited[i][j] == 3) {
            res.add(new int[]{i, j});
        }

        flow(matrix, visited, matrix[i][j], i - 1, j, k, res);
        flow(matrix, visited, matrix[i][j], i + 1, j, k, res);
        flow(matrix, visited, matrix[i][j], i, j - 1, k, res);
        flow(matrix, visited, matrix[i][j], i, j + 1, k, res);
    }
}
