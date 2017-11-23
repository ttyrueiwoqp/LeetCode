package accepted.Q101_Q200.Q151_Q160;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * <p>
 * For example, Given s = “eceba”,
 * <p>
 * T is "ece" which its length is 3.
 */
public class Q159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
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

            if (m.keySet().size() > 2) {
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

    public int sln(String s) {
        if(s.length() < 1) return 0;
        HashMap<Character,Integer> index = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while(hi < s.length()) {
            if(index.size() <= 2) {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int i : index.values()) {
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost+1;
            }
            maxLength = Math.max(maxLength, hi-lo);
        }
        return maxLength;
    }
}
