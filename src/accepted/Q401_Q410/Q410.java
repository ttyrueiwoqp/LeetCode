package accepted.Q401_Q410;

/**
 * Given an array which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.
 * <p>
 * Examples:
 * <p>
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * Output:
 * 18
 * <p>
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class Q410 {

    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        long left = max, right = sum;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (isValid(nums, mid, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    private boolean isValid(int[] nums, long limit, int m) {

        int count = 1;
        long sum = 0;
        for (int num : nums) {
            if (sum + num <= limit) {
                sum += num;
            } else {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }

        return true;
    }
}
