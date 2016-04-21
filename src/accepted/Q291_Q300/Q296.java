package accepted.Q291_Q300;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * <p>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 * <p>
 * Hint:
 * <p>
 * Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 */
public class Q296 {

    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int m = grid.length, n = grid[0].length;
        int[] x = new int[m];
        int[] y = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x[i]++;
                    y[j]++;
                }
            }
        }

        return helper(x) + helper(y);
    }

    private int helper(int[] a) {
        int res = 0, i = 0, j = a.length - 1;
        while (i < j) {
            while (a[i] == 0 && i < j) {
                i++;
            }
            while (a[j] == 0 && i < j) {
                j--;
            }
            res += j - i;
            a[i]--;
            a[j]--;
        }
        return res;
    }

    public int sln(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] I = new int[m], J = new int[n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1) {
                    ++I[i];
                    ++J[j];
                }
        int total = 0;
        for (int[] K : new int[][]{I, J}) {
            int i = 0, j = K.length - 1;
            while (i < j) {
                int k = Math.min(K[i], K[j]);
                total += k * (j - i);
                if ((K[i] -= k) == 0) ++i;
                if ((K[j] -= k) == 0) --j;
            }
        }
        return total;
    }

}
