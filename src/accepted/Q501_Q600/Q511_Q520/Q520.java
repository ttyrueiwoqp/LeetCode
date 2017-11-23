package accepted.Q501_Q600.Q511_Q520;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class Q520 {

    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len < 2) {
            return true;
        }
        char[] cs = word.toCharArray();
        boolean isFirstCap = isCap(cs[0]);
        boolean isSecondCap = isCap(cs[1]);

        if (!isFirstCap && isSecondCap) {
            return false;
        }

        for (int i = 2; i < len; i++) {
            if (isCap(cs[i]) != isSecondCap) {
                return false;
            }
        }

        return true;
    }

    private boolean isCap(char c) {
        return c - 'a' < 0;
    }


    public boolean detectCapitalUse2(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}
