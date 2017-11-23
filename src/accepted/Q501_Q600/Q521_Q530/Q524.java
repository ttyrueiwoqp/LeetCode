package accepted.Q501_Q600.Q521_Q530;

import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that
 * can be formed by deleting some characters of the given string.
 * If there are more than one possible results, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 * <p>
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * Output:
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class Q524 {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String t : d) {
            if (t.length() >= res.length() && isSubSequence(s, t)) {
                if (t.length() > res.length()) {
                    res = t;
                } else if (t.length() == res.length()) {
                    res = res.compareTo(t) < 0 ? res : t;
                }
            }
        }
        return res;
    }

    private boolean isSubSequence(String s, String t) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < t.length() && c == t.charAt(i)) {
                i++;
            }
        }
        return i == t.length();
    }
}
