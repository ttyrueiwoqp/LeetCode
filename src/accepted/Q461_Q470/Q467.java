package accepted.Q461_Q470;

/**
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * <p>
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * <p>
 * Example 1:
 * Input: "a"
 * Output: 1
 * <p>
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * Example 3:
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
public class Q467 {

    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }

        int[] arr = new int[26];
        int len = p.length();

        arr[p.charAt(len - 1) - 'a'] = 1;
        int cnt = 1;

        for (int i = len - 2; i >= 0; i--) {
            char c = p.charAt(i);
            if (isNext(c, p.charAt(i + 1))) {
                cnt++;
            } else {
                cnt = 1;
            }
            arr[c - 'a'] = Math.max(arr[c - 'a'], cnt);
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }

        return res;
    }

    private boolean isNext(char a, char b) {
        return b - a == 1 || (a == 'z' && b == 'a');
    }
}
