package accepted.Q181_Q190;

import org.junit.Test;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * <p>
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Could you do it in-place without allocating extra space?
 * <p>
 * Related problem: Rotate Array
 */
public class Q186 {

    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int i = 0, j = 0, space = 0, len = s.length;
        reverse(s, i, len - 1);
        while (space < len) {
            while (space < len && s[space] != ' ') {
                space++;
            }
            j = space - 1;
            reverse(s, i, j);
            i = ++space;
        }
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test() {
        reverseWords("a".toCharArray());
    }

    public void sln(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

}
