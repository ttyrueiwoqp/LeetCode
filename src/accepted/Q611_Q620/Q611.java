package accepted.Q611_Q620;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the
 * array that can make triangles if we take them as side lengths of a triangle.
 * <p>
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 */
public class Q611 {
    public int triangleNumber(int[] nums) {
        int res = 0;
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[k] < nums[i] + nums[j]) {
                    k++;
                }
                res += k - 1 - j;
            }
        }

        return res;
    }
}
