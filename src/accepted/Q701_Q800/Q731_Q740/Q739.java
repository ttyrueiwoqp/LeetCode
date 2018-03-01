package accepted.Q701_Q800.Q731_Q740;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class Q739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> idxStack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()) {
                stack.pop();
                int idx = idxStack.pop();
                res[idx] = i - idx;
            }
            stack.push(t);
            idxStack.push(i);
        }

        while (!idxStack.isEmpty()) {
            res[idxStack.pop()] = 0;
        }

        return res;
    }
}
