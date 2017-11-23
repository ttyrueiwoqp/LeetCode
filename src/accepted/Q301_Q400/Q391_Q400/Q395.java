package accepted.Q301_Q400.Q391_Q400;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class Q395 {

    public int longestSubstring(String s, int k) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        int idx = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] < k) {
                max = Math.max(max, longestSubstring(s.substring(idx, i), k));
                idx = i + 1;
            }
        }

        return idx == 0 ? s.length() : Math.max(max, longestSubstring(s.substring(idx), k));
    }
}
