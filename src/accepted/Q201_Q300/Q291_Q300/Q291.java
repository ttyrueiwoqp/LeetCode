package accepted.Q201_Q300.Q291_Q300;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty substring in str.
 * <p>
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 * <p>
 * Show Company Tags
 * Show Tags
 * Show Similar Problems
 */
public class Q291 {

    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(pattern.toCharArray(), 0, str, 0, new HashMap<>(), new HashMap<>());
    }

    private boolean dfs(char[] pattern, int i, String str, int j, Map<Character, String> m1, Map<String, Character> m2) {
        if (i == pattern.length) {
            return j == str.length();
        } else {
            String t = m1.get(pattern[i]);

            if (t == null) {
                for (int k = j + 1; k <= str.length(); k++) {
                    String sub = str.substring(j, k);
                    if (m2.containsKey(sub)) {
                        continue;
                    }
                    m1.put(pattern[i], sub);
                    m2.put(sub, pattern[i]);
                    if (dfs(pattern, i + 1, str, k, m1, m2)) {
                        return true;
                    }
                    m1.remove(pattern[i]);
                    m2.remove(sub);
                }
                return false;

            } else if (j + t.length() <= str.length() && t.equals(str.substring(j, j + t.length()))) {
                return dfs(pattern, i + 1, str, j + t.length(), m1, m2);
            } else {
                return false;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(wordPatternMatch("aba", "aaaa"));
    }


    public boolean sln(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatch(str, 0, pattern, 0, map, set);
    }

    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        // base case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);

            // then check if we can use it to match str[i...i+s.length()]
            if (!str.startsWith(s, i)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);

            if (set.contains(p)) {
                continue;
            }

            // create or update it
            map.put(c, p);
            set.add(p);

            // continue to match the rest
            if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                return true;
            }

            // backtracking
            map.remove(c);
            set.remove(p);
        }

        // we've tried our best but still no luck
        return false;
    }
}
