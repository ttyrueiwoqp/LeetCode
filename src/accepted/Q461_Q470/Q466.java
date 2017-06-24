package accepted.Q461_Q470;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".
 * <p>
 * On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from
 * s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can
 * not be obtained from “acbbe”.
 * <p>
 * You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and
 * 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such
 * that [S2,M] can be obtained from S1.
 * <p>
 * Example:
 * <p>
 * Input:
 * s1="acb", n1=4
 * s2="ab", n2=2
 * <p>
 * Return:
 * 2
 */
public class Q466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length(), len2 = s2.length();
        int j = 0, c2 = 0;
        int[] r = new int[len2 + 1];
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);

        for (int c1 = 1; c1 <= n1; c1++) {
            for (int i = 0; i < len1; i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == len2) {
                        j = 0;
                        c2++;
                    }
                }
            }

            r[c1] = c2;

            if (m.containsKey(j)) {
                int k = m.get(j);
                int pre = r[k];
                int mid = (r[c1] - r[k]) * (n1 - k) / (c1 - k);
                int post = r[k + (n1 - k) % (c1 - k)] - r[k];
                return (pre + mid + post) / n2;
            }

            m.put(j, c1);
        }

        return r[n1] / n2;
    }

    @Test
    public void test() {
        System.out.println(getMaxRepetitions(
                "a",
                1000000,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                1000
        ));
    }

}
