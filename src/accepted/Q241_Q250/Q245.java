package accepted.Q241_Q250;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * <p>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 * <p>
 * Note:
 * You may assume word1 and word2 are both in the list.
 */
public class Q245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {

        int idx1 = -1, idx2 = -1, res = Integer.MAX_VALUE;
        boolean diffWord = !word1.equals(word2);
        int alter = diffWord ? 0 : 1;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i]) && alter > -1) {
                idx1 = i;
                if (idx2 >= 0) {
                    res = Math.min(res, Math.abs(idx1 - idx2));
                }
                alter = diffWord ? 0 : -1;
            } else if (word2.equals(words[i]) && alter < 1) {
                idx2 = i;
                if (idx1 >= 0) {
                    res = Math.min(res, Math.abs(idx1 - idx2));
                }
                alter = diffWord ? 0 : 1;
            }
        }

        return res;
    }


















    public int sln1(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1))
                i1 = i;
            if (words[i].equals(word2)) {
                if (word1.equals(word2))
                    i1 = i2;
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;
    }

    public int sln2(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        boolean same = word1.equals(word2);
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    i1 = i2;
                    i2 = i;
                } else {
                    i1 = i;
                }
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;
    }
}
