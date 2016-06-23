package qns;

import java.util.*;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]],
 * the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class Q354 {

    public int maxEnvelopes(int[][] envelopes) {
        Map<Integer, Set<Integer>> m = new TreeMap<>();
        for (int i = 0; i < envelopes.length; i++) {
            Set<Integer> list = m.get(envelopes[i][0]);
            if (list == null) {
                list = new TreeSet<>();
                m.put(i, list);
            }
            list.add(envelopes[i][1]);
        }



        return 0;
    }

    private void helper(Map<Integer, Set<Integer>> m) {
        for (Map.Entry<Integer, Set<Integer>> e : m.entrySet()) {
            Set<Integer> set = e.getValue();
        }
    }


}
