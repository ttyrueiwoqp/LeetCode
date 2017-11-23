package accepted.Q301_Q400.Q341_Q350;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvfan on 5/2/2016.
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Q347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            Integer cnt = m.get(num);
            if (cnt == null) {
                m.put(num, 1);
            } else {
                m.put(num, cnt + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(m.entrySet());
        Collections.sort(entries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(entries.get(i).getKey());
        }

        return res;
    }
}
