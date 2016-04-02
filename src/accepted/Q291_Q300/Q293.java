package accepted.Q291_Q300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to compute all possible states of the string after one valid move.
 * <p>
 * For example, given s = "++++", after one move, it may become one of the following states:
 * <p>
 * [
 * "--++",
 * "+--+",
 * "++--"
 * ]
 * If there is no valid move, return an empty list [].
 */
public class Q293 {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == '+' && cs[i + 1] == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }

    public List<String> sln(String s) {
        List list = new ArrayList();
        for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0; )
            list.add(s.substring(0, i) + "--" + s.substring(i + 2));
        return list;
    }
}
