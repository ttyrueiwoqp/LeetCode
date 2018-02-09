package accepted.Q601_Q700.Q691_Q700;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 * <p>
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 * <p>
 * Notice that:
 * 11
 * 1
 * and
 * 1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Q694 {

    public int numDistinctIslands(int[][] grid) {
        int w = grid.length, h = grid[0].length;
        Set<String> set = new HashSet<>();
        int[][] visited = new int[w][h];
        int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, visited, dir, sb);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, int[][] visited, int[][] dir, StringBuilder sb) {
        visited[i][j] = 1;
        for (int d = 0; d < dir.length; d++) {
            int x = i + dir[d][0], y = j + dir[d][1];

            if (x >= 0 && x < grid.length
                    && y >= 0 && y < grid[0].length
                    && grid[x][y] == 1 && visited[x][y] == 0) {

                sb.append(d);
                dfs(grid, x, y, visited, dir, sb);
                sb.append(5);
            }
        }
    }
}
