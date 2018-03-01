package accepted.Q701_Q800.Q741_Q750;

import java.util.Arrays;

/**
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate
 * <p>
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * <p>
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 * <p>
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 * <p>
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * licensePlate will be a string with length in range [1, 7].
 * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class Q748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int total = 0;
        int[] arr = new int[26];
        licensePlate = licensePlate.toLowerCase();

        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                arr[c - 'a']++;
                total++;
            }
        }

        int minLen = Integer.MAX_VALUE;
        String res = "";
        for (String word : words) {
            if (word.length() >= minLen) {
                continue;
            }

            int count = total;
            int[] a = Arrays.copyOf(arr, arr.length);
            for (char c : word.toCharArray()) {
                if (a[c - 'a'] > 0) {
                    a[c - 'a']--;
                    count--;
                }
                if (count == 0) {
                    minLen = word.length();
                    res = word;
                    break;
                }
            }
        }

        return res;
    }
}
