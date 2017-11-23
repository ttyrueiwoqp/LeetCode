package accepted.Q401_Q500.Q491_Q500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array,
 * and the length of an increasing subsequence should be at least 2 .
 * <p>
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be
 * considered as a special case of increasing sequence.
 */
public class Q491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, res, list);
        return new ArrayList<>(res);
    }

    private void helper(int[] nums, int idx, Set<List<Integer>> set, List<Integer> list) {
        if (list.size() >= 2) {
            set.add(new ArrayList<>(list));
        }

        for (int i = idx; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                helper(nums, i + 1, set, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
