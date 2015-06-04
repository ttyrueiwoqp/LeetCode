package qns;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by LU-PC on 6/3/2015.
 * <p>
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 */
public class Q063 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return 0;
	}

	public int uniquePaths(int m, int n) {

		return getRow(m+n-2).get(n-1);
	}

	public List<Integer> getRow(int rowIndex) {

		List<Integer> res = new ArrayList<>();

		if (rowIndex == 0) {
			res.add(1);
		} else {
			List<Integer> last = getRow(rowIndex - 1);
			for (int i = 0; i < last.size() - 1; i++) {
				res.add(last.get(i) + last.get(i + 1));
			}
			res.add(0, 1);
			res.add(1);
		}

		return res;
	}

	@Test
	public void test() {
		assertEquals(6, uniquePaths(3, 3));
	}
}
