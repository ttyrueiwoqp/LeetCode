package accepted.Q171_Q180;

import org.junit.Test;

/**
 * Created by FJ on 3/10/2016.
 * <p/>
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid.
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * <p/>
 * The knight has an initial health point represented by a positive integer.
 * If at any point his health point drops to 0 or below, he dies immediately.
 * <p/>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * <p/>
 * In order to reach the princess as quickly as possible,
 * the knight decides to move only rightward or downward in each step.
 * <p/>
 * <p/>
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p/>
 * For example, given the dungeon below,
 * the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * <p/>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p/>
 * Notes:
 * <p/>
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups,
 * even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class Q174 {

	public int calculateMinimumHP(int[][] dungeon) {

		int m = dungeon.length;
		if (m == 0) {
			return 0;
		}
		int n = dungeon[0].length;
		if (n == 0) {
			return 0;
		}

		int[][] health = new int[m][n];
		health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

		for (int i = m - 2; i >= 0; i--) {
			health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
		}
		for (int j = n - 2; j >= 0; j--) {
			health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int need = Math.min(health[i + 1][j], health[i][j + 1]) - dungeon[i][j];
				health[i][j] = Math.max(need, 1);
			}
		}

		return health[0][0];
	}

	@Test
	public void test() {
		int[][] a = {
				{-2, -3, 3},
				{-5, -10, 1},
				{10, 30, -5}};

		int[][] b = {
				{1, -3, 3},
				{0, -2, 0},
				{-3, -3, -3}};
		System.out.println(calculateMinimumHP(a));
		System.out.println(calculateMinimumHP(b));
	}
}
