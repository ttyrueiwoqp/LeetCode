package accepted.Q381_Q390;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class Q387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> m = new LinkedHashMap<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (m.containsKey(cs[i])) {
                m.put(cs[i], -Math.abs(m.get(cs[i])) - 1);
            } else {
                m.put(cs[i], i);
            }
        }
        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            if (e.getValue() >= 0) {
                return e.getValue();
            }
        }
        return -1;
    }
}
