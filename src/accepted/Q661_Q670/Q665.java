package accepted.Q661_Q670;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * <p>
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first
 * 4
 * to
 * 1
 * to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * Note: The n belongs to [1, 10,000].
 */
public class Q665 {
    public boolean checkPossibility(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;

        for (int num : nums) {

            if (!stack.isEmpty() && num < stack.peek()) {
                count++;
                if (count > 1) {
                    return false;
                }

                Integer top = stack.pop();
                if (stack.isEmpty() || num >= stack.peek()) {
                    stack.push(num);
                } else {
                    stack.push(top);
                    num = top;
                }

            }
            stack.push(num);
        }

        return true;
    }
}
