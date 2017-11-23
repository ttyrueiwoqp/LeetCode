package accepted.Q101_Q200.Q191_Q200;

import org.junit.Test;

/**
 * Created by LU-PC on 6/15/2015.
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * <p>
 * Example 2:
 * <p>
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class Q200 {
	public int numIslands(char[][] grid) {
		int res = 0;
		if (grid.length == 0 || grid[0].length == 0) {
			return res;
		}

		int[][] tracker = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (tracker[i][j] == 1) {
					continue;
				}
				if (grid[i][j] == '1') {
					flood(grid, tracker, i, j);
					res++;
				}
			}
		}
		return res;
	}

	private void flood(char[][] grid, int[][] tracker, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == '0' || tracker[i][j] == 1) {
			return;
		}
		tracker[i][j] = 1;

		flood(grid, tracker, i - 1, j);
		flood(grid, tracker, i, j - 1);
		flood(grid, tracker, i + 1, j);
		flood(grid, tracker, i, j + 1);
	}

	@Test
	public void test() {
		char[][] grid = {{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		System.out.println(numIslands(grid));

		char[][] grid2 = {{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}};
		System.out.println(numIslands(grid2));
	}
}
