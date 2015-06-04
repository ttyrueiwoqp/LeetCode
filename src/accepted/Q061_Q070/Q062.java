package accepted.Q061_Q070;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 */
public class Q062 {
	public int uniquePaths(int m, int n) {

		return getRow(m + n - 2).get(n - 1);
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
