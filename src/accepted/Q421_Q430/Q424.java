package accepted.Q421_Q430;

/**
 * Given a string that consists of only uppercase English letters,
 * you can replace any letter in the string with another letter at most k times.
 * Find the length of a longest substring containing all repeating letters you can get after
 * performing the above operations.
 * <p>
 * Note:
 * Both the string's length and k will not exceed 104.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "ABAB", k = 2
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * <p>
 * Input:
 * s = "AABABBA", k = 1
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class Q424 {

    public int characterReplacement(String s, int k) {
        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            res = Math.max(res, helper(s, c, k));
        }
        return res;
    }

    private int helper(String s, char c, int k) {
        int len = s.length();
        int p = 0, count = 0, max = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != c) {
                count++;
                if (count > k) {
                    max = Math.max(max, i - p);
                    while (p < len && s.charAt(p) == c) {
                        p++;
                    }
                    p++;
                    count--;
                }
            }
        }

        return Math.max(max, len - p);
    }
}
