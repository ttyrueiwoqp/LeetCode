package accepted.Q301_Q400.Q341_Q350;

/**
 * Created by lvfan on 4/26/2016.
 *
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Q344 {
    public String reverseString(String s) {
        char[] cs = s.toCharArray();
        int st = 0, end = s.length() - 1;

        while (st < end) {

            char temp = cs[st];
            cs[st] = cs[end];
            cs[end] = temp;

            st++;
            end--;
        }
        return String.valueOf(cs);
    }
}
