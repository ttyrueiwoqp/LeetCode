package accepted.Q701_Q800.Q711_Q720;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * <p>
 * Example 1:
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 * Note:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class Q718 {

    public int findLength(int[] A, int[] B) {

        int res = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    res = Math.max(res, dp[i + 1][j + 1]);
                }
            }
        }

        return res;
    }
}
