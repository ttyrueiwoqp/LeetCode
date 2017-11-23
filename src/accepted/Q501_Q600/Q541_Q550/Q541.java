package accepted.Q501_Q600.Q541_Q550;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k
 * characters counting from the start of the string. If there are less than k characters left,
 * reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class Q541 {

    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i += 2*k) {
            StringBuilder sb = new StringBuilder();
            if (i + k > len) {
                sb.append(s.substring(i));
                sb.reverse();
                res.append(sb);
            } else {

                sb.append(s.substring(i, i + k));
                sb.reverse();
                res.append(sb);

                if (i + 2*k > len) {
                    res.append(s.substring(i + k));
                } else {
                    res.append(s.substring(i + k, i + 2*k));
                }
            }
        }

        return res.toString();
    }
}
