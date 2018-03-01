package accepted.Q701_Q800.Q771_Q780;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 * <p>
 * Examples:
 * Input: N = 1, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 2
 * Output: 1
 * <p>
 * Input: N = 4, K = 5
 * Output: 1
 * <p>
 * Explanation:
 * row 1: 0
 * row 2: 01
 * row 3: 0110
 * row 4: 01101001
 * Note:
 * <p>
 * N will be an integer in the range [1, 30].
 * K will be an integer in the range [1, 2^(N-1)].
 */
public class Q779 {

    public int kthGrammar(int N, int K) {
        int[][] a = new int[][]{{0, 1}, {1, 0}};
        return helper(N, K, a);
    }

    private int helper(int N, int K, int[][] a) {
        if (N == 1) {
            return 0;
        }
        return a[helper(N - 1, (K + 1) / 2, a)][(K + 1) % 2];
    }
}
