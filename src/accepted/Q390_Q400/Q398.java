package accepted.Q390_Q400;

import java.util.*;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class Q398 {

    Map<Integer, List<Integer>> m;
    Random rand;

    public Q398(int[] nums) {
        m = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> idxs = m.get(nums[i]);
            if (idxs == null) {
                idxs = new ArrayList<>();
                m.put(nums[i], idxs);
            }
            idxs.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> idxs = m.get(target);
        return idxs.get(rand.nextInt(idxs.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */