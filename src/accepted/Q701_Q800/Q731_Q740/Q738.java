package accepted.Q701_Q800.Q731_Q740;

/**
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * <p>
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 * <p>
 * Example 1:
 * Input: N = 10
 * Output: 9
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 * Example 3:
 * Input: N = 332
 * Output: 299
 * Note: N is an integer in the range [0, 10^9].
 */
public class Q738 {

    public int monotoneIncreasingDigits(int N) {
        char[] cs = String.valueOf(N).toCharArray();
        int i = 1, k = 0;
        while (i < cs.length) {
            if (cs[i] < cs[i - 1]) {
                break;
            } else if (cs[i] > cs[i - 1]) {
                k = i;
            }
            i++;
        }

        if (i < cs.length) {
            cs[k]--;
            for (int j = k + 1; j < cs.length; j++) {
                cs[j] = '9';
            }
            return Integer.parseInt(String.valueOf(cs));
        }

        return N;
    }
}
