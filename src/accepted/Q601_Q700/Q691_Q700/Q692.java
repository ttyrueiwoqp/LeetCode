package accepted.Q601_Q700.Q691_Q700;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class Q692 {

    public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> m.get(a) == m.get(b) ? b.compareTo(a) : m.get(a) - m.get(b));

        for (String w : words) {
            m.put(w, m.getOrDefault(w, 0) + 1);
        }

        for (String s : m.keySet()) {
            pq.offer(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        Collections.reverse(res);

        return res;
    }
}
