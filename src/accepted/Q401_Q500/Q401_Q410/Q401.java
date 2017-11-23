package accepted.Q401_Q500.Q401_Q410;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lvfan on 10/23/2016.
 * <p>
 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * <p>
 * For example, the above binary watch reads "3:25".
 * <p>
 * Given a non-negative integer n which represents the number of LEDs that are currently on,
 * return all possible times the watch could represent.
 * <p>
 * Example:
 * <p>
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid,
 * it should be "10:02".
 */
public class Q401 {

    public List<String> readBinaryWatch(int num) {

        List<String> res = new ArrayList<>();

        Map<Integer, Set<Integer>> m = helper(num);
        for (Map.Entry<Integer, Set<Integer>> e : m.entrySet()) {
            for (Integer min : e.getValue()) {
                String minStr = (min < 10 ? "0" : "") + min;
                res.add(e.getKey() + ":" + minStr);
            }
        }
        return res;
    }

    public Map<Integer, Set<Integer>> helper(int num) {

        Map<Integer, Set<Integer>> m = new HashMap<>();
        if (num > 8 || num < 0) {
            return m;
        }

        if (num == 0) {
            Set<Integer> set = new HashSet<>();
            set.add(0);
            m.put(0, set);
            return m;
        }

        Map<Integer, Set<Integer>> prevM = helper(num - 1);
        for (Map.Entry<Integer, Set<Integer>> e : prevM.entrySet()) {
            Set<Integer> newHrs = incrHr(e.getKey());
            for (Integer newHr : newHrs) {
                m.put(newHr, e.getValue());
            }

            Set<Integer> newMins = incrMins(e.getValue());
            m.put(e.getKey(), newMins);
        }

        return m;
    }

    private Set<Integer> incrHr(Integer hr) {
        Set<Integer> newHrs = new HashSet<>();
        for (int i = 1; i <= 8; i *= 2) {
            if ((hr & i) == 0 && hr + i < 12) {
                newHrs.add(hr + i);
            }
        }
        return newHrs;
    }

    private Set<Integer> incrMins(Set<Integer> mins) {
        Set<Integer> newMins = new HashSet<>();
        for (Integer min : mins) {
            for (int i = 1; i <= 32; i *= 2) {
                if ((min & i) == 0 && min + i < 60) {
                    newMins.add(min + i);
                }
            }
        }
        return newMins;
    }
}
