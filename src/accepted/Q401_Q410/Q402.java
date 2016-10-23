package accepted.Q401_Q410;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Q402 {

    public String removeKdigits(String num, int k) {

        if (num.length() == k || num.length() == 0) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();

        int removeCnt = 0;
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && c < stack.peek() && removeCnt < k) {
                stack.pop();
                removeCnt++;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        int lastNonZeroLen = 1;
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            if (stack.size() >= num.length() - k) {
                continue;
            }

            sb.append(c);
            if (c != '0') {
                lastNonZeroLen = sb.length();
            }
        }

        sb.setLength(lastNonZeroLen);

        return sb.reverse().toString();
    }
}
