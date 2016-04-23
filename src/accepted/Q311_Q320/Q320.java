package accepted.Q311_Q320;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Write a function to generate the generalized abbreviations of a word.
 * <p>
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * <p>
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class Q320 {

    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        helper(res, word.toCharArray(), new StringBuilder(), 0, 0);
        return res;
    }

    private void helper(List<String> res, char[] cs, StringBuilder sb, int i, int num) {
        int len = sb.length();
        if (i == cs.length) {
            if (num > 0) {
                sb.append(num);
            }
            res.add(sb.toString());
        } else {

            helper(res, cs, sb, i + 1, num + 1);

            if (num > 0) {
                sb.append(num);
            }
            helper(res, cs, sb.append(cs[i]), i + 1, 0);
        }

        sb.setLength(len);
    }

    public List<String> sln(String word) {
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            ret.add(cur);
        } else {
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }

}
