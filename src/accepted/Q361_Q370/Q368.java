package accepted.Q361_Q370;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers,
 * find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * nums: [1,2,3]
 * <p>
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * nums: [1,2,4,8]
 * <p>
 * Result: [1,2,4,8]
 */
public class Q368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();

            int max = 0;
            List<Integer> maxList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0) {
                    if (dp.get(j).size() > max) {
                        max = dp.get(j).size();
                        maxList = dp.get(j);
                    }
                }
            }

            list.addAll(maxList);
            list.add(nums[i]);
            dp.add(list);
        }

        dp.sort((o1, o2) -> o2.size() - o1.size());

        return dp.get(0);
    }
}
