package accepted.Q251_Q260;

import java.util.Arrays;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k
 * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p>
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * <p>
 * Return 2. Because there are two triplets which sums are less than 2:
 * <p>
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Follow up:
 * Could you solve it in O(n2) runtime?
 */
public class Q259 {

    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;

        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }

    int count;

    public int sln(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
