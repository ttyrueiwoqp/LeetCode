package accepted.Q401_Q500.Q441_Q450;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j
 * equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class Q447 {

    public int numberOfBoomerangs(int[][] points) {
        if (points.length == 0 || points[0].length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> m = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = calcSqrDist(points, i, j);
                    if (m.containsKey(d)) {
                        m.put(d, m.get(d) + 1);
                    } else {
                        m.put(d, 1);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> e : m.entrySet()) {
                int v = e.getValue();
                if (v > 1) {
                    res += (v - 1) * v;
                }
            }
        }

        return res;
    }

    private int calcSqrDist(int[][] points, int i, int j) {

        int a = points[i][0] - points[j][0];
        int b = points[i][1] - points[j][1];
        return a * a + b * b;
    }
}
