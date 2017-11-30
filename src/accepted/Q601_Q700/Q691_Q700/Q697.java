package accepted.Q601_Q700.Q691_Q700;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class Q697 {

    public int findShortestSubArray(int[] nums) {

        int maxDegree = 0, minLength = Integer.MAX_VALUE;

        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Integer> stIndexMap = new HashMap<>();
        Map<Integer, Integer> endIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            degreeMap.merge(n, 1, Integer::sum);
            maxDegree = Math.max(maxDegree, degreeMap.get(n));
            stIndexMap.putIfAbsent(n, i);
            endIndexMap.put(n, i);
        }

        for (Map.Entry<Integer, Integer> e : degreeMap.entrySet()) {
            if (e.getValue() == maxDegree) {
                minLength = Math.min(minLength, endIndexMap.get(e.getKey()) - stIndexMap.get(e.getKey()));
            }
        }

        return minLength + 1;
    }
}
