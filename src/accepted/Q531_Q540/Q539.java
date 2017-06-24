package accepted.Q531_Q540;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 * <p>
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
public class Q539 {

    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2) {
            return -1;
        }
        List<Integer> ps = new ArrayList<>();
        for (String p : timePoints) {
            int min = Integer.parseInt(p.substring(0, 2)) * 60 + Integer.parseInt(p.substring(3));
            ps.add(min);
        }
        Collections.sort(ps);
        int res = diff(ps, 0, ps.size() - 1);
        for (int i = 1; i < ps.size(); i++) {
            res = Math.min(res, diff(ps, i, i - 1));
        }
        return res;
    }

    private int diff(List<Integer> ps, int i, int j) {
        int d = Math.abs(ps.get(i) - ps.get(j));
        return d < 720 ? d : 1440 - d;
    }
}
