package accepted.Q390_Q400;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Q394 {
    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                stack.push(sb.toString());
                sb.setLength(0);

            } else if (c == ']') {
                String top = stack.pop();
                int idx = getIdx(top);
                int n = Integer.parseInt(top.substring(idx));
                String temp = sb.toString();
                for (int j = 0; j < n - 1; j++) {
                    sb.append(temp);
                }
                sb.insert(0, top.substring(0, idx));

                if (stack.isEmpty()) {
                    result.append(sb);
                    sb.setLength(0);
                }

            } else {
                sb.append(c);
            }
        }

        return result.append(sb).toString();
    }

    private int getIdx(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
