package accepted.Q521_Q530;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings, you need to find the longest uncommon subsequence among them.
 * The longest uncommon subsequence is defined as the longest subsequence of one of these
 * strings and this subsequence should not be any subsequence of the other strings.
 * <p>
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters
 * without changing the order of the remaining elements. Trivially, any string is a subsequence
 * of itself and an empty string is a subsequence of any string.
 * <p>
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon
 * subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 * <p>
 * Example 1:
 * Input: "aba", "cdc", "eae"
 * Output: 3
 * Note:
 * <p>
 * All the given strings' lengths will not exceed 10.
 * The length of the given list will be in the range of [2, 50].
 */
public class Q522 {

    public int findLUSlength(String[] strs) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (String s : strs) {
            if (set2.contains(s)) {
                continue;
            }
            if (set1.contains(s)) {
                set1.remove(s);
                set2.add(s);
            } else {
                set1.add(s);
            }
        }

        int res = -1;
        for (String s : set1) {
            if (s.length() <= res) {
                continue;
            }
            boolean hasSubseq = false;
            for (String s2 : set2) {
                if (s.length() <= s2.length() && isSubseq(s, s2)) {
                    hasSubseq = true;
                    break;
                }
            }
            if (!hasSubseq) {
                res = s.length();
            }
        }

        return res;
    }

    private boolean isSubseq(String s, String s2) {
        int i = 0;
        for (char c : s2.toCharArray()) {
            if (c == s.charAt(i)) {
                i++;
            }
            if (i == s.length()) {
                break;
            }
        }

        return i == s.length();
    }
}
