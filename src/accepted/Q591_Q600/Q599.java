package accepted.Q591_Q600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
 * represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between
 * answers, output all of them with no order requirement. You could assume there always exists an answer.
 * <p>
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class Q599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            m.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer idx1 = m.get(list2[i]);
            if (idx1 != null) {
                if (idx1 + i < min) {
                    res = new ArrayList<>();
                }
                if (idx1 + i <= min) {
                    min = idx1 + i;
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
