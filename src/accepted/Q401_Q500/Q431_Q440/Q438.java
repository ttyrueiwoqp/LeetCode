package accepted.Q401_Q500.Q431_Q440;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Q438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        Map<Character, Integer> m = new HashMap<>();
        for (char c : p.toCharArray()) {
            Integer cnt = m.get(c);
            if (cnt == null) {
                m.put(c, 1);
            } else {
                m.put(c, cnt + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer cnt = m.get(c);
            if (cnt == null) {
                m.put(c, -1);
            } else if (cnt == 1) {
                m.remove(c);
            } else {
                m.put(c, cnt - 1);
            }

            if (i >= p.length()) {
                char t = s.charAt(i - p.length());
                Integer tVal = m.get(t);
                if (tVal == null) {
                    m.put(t, 1);
                } else if (tVal == -1) {
                    m.remove(t);
                } else {
                    m.put(t, tVal + 1);
                }
            }

            if (m.isEmpty()) {
                res.add(i - p.length() + 1);
            }

        }

        return res;
    }
}
