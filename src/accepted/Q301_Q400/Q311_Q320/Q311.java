package accepted.Q301_Q400.Q311_Q320;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given two sparse matrices A and B, return the result of AB.
 * <p>
 * You may assume that A's column number is equal to B's row number.
 * <p>
 * Example:
 * <p>
 * A = [
 * [ 1, 0, 0],
 * [-1, 0, 3]
 * ]
 * <p>
 * B = [
 * [ 7, 0, 0 ],
 * [ 0, 0, 0 ],
 * [ 0, 0, 1 ]
 * ]
 * <p>
 * <p>
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 */
public class Q311 {

    public int[][] multiply(int[][] A, int[][] B) {
        int am = A.length, bm = B.length;
        if (am == 0 || bm == 0) {
            return null;
        }

        int an = A[0].length, bn = B[0].length;
        int[][] res = new int[am][bn];

        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int j = 0; j < bn; j++) {
            Map<Integer, Integer> m = new HashMap<>();
            list.add(m);
            for (int k = 0; k < bm; k++) {
                if (B[k][j] != 0) {
                    m.put(k, B[k][j]);
                }
            }
        }

        for (int i = 0; i < am; i++) {
            for (int j = 0; j < bn; j++) {
                Map<Integer, Integer> m = list.get(j);
                for (Map.Entry<Integer, Integer> e : m.entrySet()) {
                    res[i][j] += A[i][e.getKey()] * e.getValue();
                }
            }
        }

        return res;
    }

    public int[][] sln(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }
}
