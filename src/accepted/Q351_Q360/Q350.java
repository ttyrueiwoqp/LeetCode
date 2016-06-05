package accepted.Q351_Q360;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to num2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited
 * such that you cannot load all elements into the memory at once?
 */
public class Q350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num1 : nums1) {
            Integer i = m.get(num1);
            if (i == null) {
                m.put(num1, 1);
            } else {
                m.put(num1, i + 1);
            }
        }

        for (int num2 : nums2) {
            if (m.containsKey(num2) && m.get(num2) > 0) {
                list.add(num2);
                m.put(num2, m.get(num2) - 1);
            }
        }

        int[] res = new int[list.size()];
        int idx = 0;
        for (Integer i : list) {
            res[idx] = i;
            idx++;
        }

        return res;
    }
}
