package accepted.Q331_Q340;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvfan on 4/25/2016.
 * <p>
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * <p>
 * For example, Given s = “eceba” and k = 2,
 * <p>
 * T is "ece" which its length is 3.
 * <p>
 * Show Company Tags
 * Show Tags
 * Show Similar Problems
 */
public class Q340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        int res = 0;
        int len = s.length();
        Map<Character, Integer> m = new HashMap<>();
        Character[] t = new Character[len];

        int p = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            Integer idx = m.get(c);

            if (idx != null) {
                t[idx] = null;
            }
            m.put(c, i);
            t[i] = c;

            if (m.keySet().size() > k) {
                res = Math.max(res, i - p);

                while (p < len && t[p] == null) {
                    p++;
                }
                m.remove(t[p]);
                t[p] = null;
                p++;
            }

            if (i == len - 1) {
                res = Math.max(res, len - p);
            }
        }

        return res;
    }


    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstringKDistinct("a", 1));
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    public int sln(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

}
