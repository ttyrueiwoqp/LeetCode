package accepted.Q351_Q360;

import java.util.Arrays;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * <p>
 * Subscribe to see which companies asked this question
 */
public class Q354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));

        int len = envelopes.length;
        int[] dp = new int[len];
        int res = 0;

        for (int[] envelop : envelopes) {
            int idx = Arrays.binarySearch(dp, 0, res, envelop[1]);
            idx = idx < 0 ? -(idx + 1) : idx;
            dp[idx] = envelop[1];
            if (idx == res) {
                res++;
            }
        }

        return res;
    }
}
