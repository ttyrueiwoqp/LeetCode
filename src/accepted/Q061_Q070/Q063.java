package accepted.Q061_Q070;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by LU-PC on 6/3/2015.
 * <p/>
 * Follow up for "Unique Paths":
 * <p/>
 * Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 * <p/>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p/>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p/>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p/>
 * Note: m and n will be at most 100.
 */
public class Q063 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		if (m == 0) {
			return 0;
		}
		int n = obstacleGrid[0].length;

		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else {
					int top = (i == 0) ? 0 : dp[i - 1][j];
					int left = (j == 0) ? 0 : dp[i][j - 1];
					dp[i][j] = top + left;
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	@Test
	public void test() {
		int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		assertEquals(2, uniquePathsWithObstacles(a));
	}
}
