package accepted.Q401_Q500.Q451_Q460;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a sequence of n integers a1, a2, ..., an,
 * a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
 * Design an algorithm that takes a list of n numbers as input and
 * checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class Q456 {

    public boolean find132pattern(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int s3 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                s3 = stack.peek();
                stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}
