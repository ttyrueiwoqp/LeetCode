package accepted.Q641_Q650;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in
 * the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number
 * occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 */
public class Q645 {

    public int[] findErrorNums(int[] nums) {
        int sum = 0, n = nums.length;
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums[i]);

            if (nums[abs - 1] < 0) {
                res[0] = abs;
            }
            nums[abs - 1] = 0 - nums[abs - 1];

            sum += abs;
        }

        res[1] = (1 + n) * n / 2 - sum + res[0];

        return res;
    }
}
