package accepted.Q201_Q300.Q291_Q300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to determine if the starting player can guarantee a win.
 * <p>
 * For example, given s = "++++", return true.
 * The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * <p>
 * Follow up:
 * Derive your algorithm's runtime complexity.
 */
public class Q294 {

    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == '+' && cs[i + 1] == '+') {
                if (!canWin(s.substring(0, i) + "++" + s.substring(i + 2))) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean sln(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);

                if (!canWin(t)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean sln2(String s) {
        if (s == null || s.length() < 2) return false;
        Map<String, Boolean> map = new HashMap<>();
        return canWin(s, map);
    }

    public boolean canWin(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(opponent, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
