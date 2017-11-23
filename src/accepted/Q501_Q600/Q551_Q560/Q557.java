package accepted.Q501_Q600.Q551_Q560;

/**
 * Given a string, you need to reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class Q557 {

    public String reverseWords(String s) {

        StringBuilder res = new StringBuilder();
        String[] parts = s.split(" ");
        for (int i = 0; i < parts.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(parts[i]);
            sb.reverse();
            res.append(sb);
            if (i < parts.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }

}
