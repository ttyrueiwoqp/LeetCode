package accepted.Q301_Q400.Q381_Q390;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space.
 * The input size may be as large as 5,000,000.
 */
public class Q386 {

    public List<Integer> lexicalOrder(int n) {

        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0);
        while (!stack.isEmpty()) {
            int k = stack.pop();
            res.add(k);
            k *= 10;

            if (k <= n) {
                for (int i = k + 9; i >= k; i--) {
                    if (i <= n && i > 0) {
                        stack.push(i);
                    }
                }
            }
        }

        return res.subList(1, res.size());
    }
}
