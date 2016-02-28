package accepted.Q331_Q340;

import org.junit.Test;

/**
 * Created by FJ on 2/28/2016.
 * <p/>
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north,
 * then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on.
 * other words, after each move your direction changes counter-clockwise.
 * <p/>
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 * <p/>
 * Example 1:
 * Given x = [2, 1, 1, 2],
 * ┌───┐
 * │     │
 * └───┼──>
 * │
 * <p/>
 * Return true (self crossing)
 * Example 2:
 * Given x = [1, 2, 3, 4],
 * ┌──────┐
 * │          │
 * │
 * │
 * └────────────>
 * <p/>
 * Return false (not self crossing)
 * Example 3:
 * Given x = [1, 1, 1, 1],
 * ┌───┐
 * │     │
 * └───┼>
 * <p/>
 * Return true (self crossing)
 */
public class Q335 {
	public boolean isSelfCrossing(int[] x) {
		int len = x.length;
		if (len < 4) {
			return false;
		}

		boolean inner = false;
		int i = 2;
		while (i < len) {
			if (!inner && x[i] <= x[i - 2]) {
				inner = true;
				if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4])
						|| (i == 3 && x[i] == x[i - 2])) {
					if (i + 1 < len && x[i + 1] >= x[i - 1] - x[i - 3]) {
						return true;
					}
				}
			} else if (inner && x[i] >= x[i - 2]) {
				return true;
			}

			i++;
		}

		return false;
	}

	@Test
	public void test() {
		int[][] a = {
				{3, 3, 4, 2, 2},
				{2, 1, 1, 2},
				{1, 2, 3, 4},
				{1, 1, 1, 1},
				{1, 2, 3, 4, 1, 3},
				{1, 2, 3, 4, 1, 4},
				{1, 2, 3, 4, 1, 5},
				{1, 2, 3, 4, 2, 1},
				{1, 2, 3, 4, 2, 2},
				{1, 2, 3, 4, 2, 3},
				{1, 2, 3, 4, 3, 1},
				{1, 2, 3, 4, 3, 2},
				{1, 2, 3, 4, 4, 3}};
		for (int[] i : a) {
			System.out.println(isSelfCrossing(i));
		}

	}
}
