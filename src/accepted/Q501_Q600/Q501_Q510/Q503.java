package accepted.Q501_Q600.Q501_Q510;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number
 * to its traversing-order next in the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */
public class Q503 {

    public int[] nextGreaterElements(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];

        Deque<int[]> stack = new ArrayDeque<>();
        for (int j = 0; j < len * 2; j++) {
            int num = nums[j % len];
            while (!stack.isEmpty() && num > stack.peek()[1]) {
                res[stack.pop()[0]] = num;
            }
            if (j < len) {
                stack.push(new int[]{j, num});
            }
        }

        while (!stack.isEmpty()) {
            res[stack.pop()[0]] = -1;
        }

        return res;
    }
}
