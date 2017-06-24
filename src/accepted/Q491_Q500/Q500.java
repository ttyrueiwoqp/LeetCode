package accepted.Q491_Q500;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet
 * on only one row's of American keyboard like the image below.
 * <p>
 * <p>
 * American keyboard
 * <p>
 * <p>
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
public class Q500 {
    public String[] findWords(String[] words) {
        String[] strs = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};

        int[] arr = new int[255];
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                arr[c] = i + 1;
            }
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            int curr = -1;
            boolean isSameRow = true;
            for (char c : word.toCharArray()) {
                if (curr != -1 && arr[c] != curr) {
                    isSameRow = false;
                    break;
                }
                curr = arr[c];
            }
            if (isSameRow) {
                res.add(word);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
