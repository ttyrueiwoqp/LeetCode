package accepted.Q451_Q460;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class Q451 {

    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<>();
        Map<Integer, Set<Character>> m2 = new HashMap<>();
        int max = 0;

        for (char c : s.toCharArray()) {
            int i = 0;
            if (m.containsKey(c)) {
                i = m.get(c);
                m2.get(i).remove(c);
            }

            m.put(c, i + 1);
            Set<Character> set = m2.get(i + 1);
            if (set == null) {
                set = new HashSet<>();
                m2.put(i + 1, set);
            }
            set.add(c);

            max = Math.max(max, i + 1);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = max; i >= 1; i--) {
            Set<Character> set = m2.get(i);
            for (char c : set) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

}
