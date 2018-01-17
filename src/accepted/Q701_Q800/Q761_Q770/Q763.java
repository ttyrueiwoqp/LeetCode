package accepted.Q701_Q800.Q761_Q770;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A string S of lowercase letters is given. We want to partition this string into as
 * many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits S into less parts.
 * Note:
 * <p>
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */
public class Q763 {

    public List<Integer> partitionLabels(String S) {

        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> m = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (char c : S.toCharArray()) {
            m.merge(c, 1, Integer::sum);
        }

        int n = 0;
        for (char c : S.toCharArray()) {
            n++;
            if (!m2.containsKey(c)) {
                m2.put(c, m.get(c) - 1);
            } else {
                m2.put(c, m2.get(c) - 1);
            }
            if (m2.get(c) == 0) {
                m2.remove(c);
            }
            if (m2.isEmpty()) {
                res.add(n);
                n = 0;
            }
        }

        return res;
    }
}
