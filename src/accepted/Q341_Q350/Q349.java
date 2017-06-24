package accepted.Q341_Q350;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Q349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            if (set1.contains(num2)) {
                set2.add(num2);
            }
        }

        int[] res = new int[set2.size()];
        int idx = 0;
        for (Integer i : set2) {
            res[idx] = i;
            idx++;
        }
        return res;
    }
}
