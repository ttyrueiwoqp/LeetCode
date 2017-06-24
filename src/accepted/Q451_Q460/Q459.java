package accepted.Q451_Q460;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * <p>
 * Example 1:
 * Input: "abab"
 * <p>
 * Output: True
 * <p>
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * <p>
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * <p>
 * Output: True
 * <p>
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class Q459 {

    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int len = str.length();

        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                String sub = str.substring(0, i);
                int j;
                for (j = 0; j < len / i; j++) {
                    if (!sub.equals(str.substring(i * j, i * (j + 1)))) {
                        break;
                    }
                }
                if (j == len / i) {
                    return true;
                }
            }
        }

        return false;
    }
}
