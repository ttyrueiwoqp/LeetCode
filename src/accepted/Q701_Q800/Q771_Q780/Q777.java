package accepted.Q701_Q800.Q771_Q780;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
 * <p>
 * Example:
 * <p>
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * Note:
 * <p>
 * 1 <= len(start) = len(end) <= 10000.
 * Both start and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class Q777 {

    public boolean canTransform(String start, String end) {
        List<Integer> stIdxes = new ArrayList<>();
        List<Integer> endIdxes = new ArrayList<>();

        String a = removeX(start, stIdxes);
        String b = removeX(end, endIdxes);

        if (!a.equals(b)) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'L' && stIdxes.get(i) < endIdxes.get(i)) {
                return false;
            }
            if (a.charAt(i) == 'R' && stIdxes.get(i) > endIdxes.get(i)) {
                return false;
            }
        }

        return true;
    }

    private String removeX(String s, List<Integer> idxes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'X') {
                sb.append(c);
                idxes.add(i);
            }
        }

        return sb.toString();
    }

}
