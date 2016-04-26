package accepted.Q341_Q350;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lvfan on 4/26/2016.
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Show Company Tags
 * Show Tags
 * Show Similar Problems
 */
public class Q345 {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] cs = s.toCharArray();
        int st = 0, end = s.length() - 1;
        while (st < end) {

            while (st < end && !vowels.contains(cs[st])) {
                st++;
            }

            while (st < end && !vowels.contains(cs[end])) {
                end--;
            }

            if (st < end) {
                char temp = cs[st];
                cs[st] = cs[end];
                cs[end] = temp;
            }

            st++;
            end--;
        }

        return String.valueOf(cs);
    }
}
