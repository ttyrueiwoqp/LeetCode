package accepted.Q201_Q300.Q241_Q250;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * <p>
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Q243 {
    public int shortestDistance(String[] words, String word1, String word2) {

        int idx1 = -1, idx2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                idx1 = i;
                if (idx2 >= 0) {
                    res = Math.min(res, Math.abs(idx1 - idx2));
                }
            } else if (word2.equals(words[i])) {
                idx2 = i;
                if (idx1 >= 0) {
                    res = Math.min(res, Math.abs(idx1 - idx2));
                }
            }
        }

        return res;
    }


    public int sln(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                p1 = i;

            if (words[i].equals(word2))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }
}
