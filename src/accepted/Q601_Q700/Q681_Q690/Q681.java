package accepted.Q601_Q700.Q681_Q690;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * <p>
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34",
 * "12:9" are all invalid.
 * <p>
 * Example 1:
 * <p>
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Example 2:
 * <p>
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned
 * time is next day's time since it is smaller than the input time numerically.
 */
public class Q681 {

    public String nextClosestTime(String time) {
        List<Integer> ds = new ArrayList<>();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                ds.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        int self = (ds.get(0) * 10 + ds.get(1)) * 100 + ds.get(2) * 10 + ds.get(3);
        int min = Integer.MAX_VALUE;
        Integer close = null;
        Set<Integer> digits = new HashSet<>(ds);
        for (int d0 : digits) {
            if (d0 > 2) continue;

            for (int d1 : digits) {
                if (d0 * 10 + d1 > 23) continue;

                for (int d2 : digits) {
                    if (d2 > 5) continue;

                    for (int d3 : digits) {
                        int val = (d0 * 10 + d1) * 100 + d2 * 10 + d3;
                        min = Math.min(min, val);
                        if (val > self && (close == null || close > val)) {
                            close = val;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(close == null ? min : close);

        int nLeadingZeros = 4 - sb.length();
        for (int i = 0; i < nLeadingZeros; i++) {
            sb.insert(0, 0);
        }

        return sb.substring(0, 2) + ":" + sb.substring(2);
    }

}
