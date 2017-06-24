package accepted.Q431_Q440;

import util.Interval;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given a set of intervals, for each of the interval i, check if there exists an interval j
 * whose start point is bigger than or equal to the end point of the interval i,
 * which can be called that j is on the "right" of i.
 * <p>
 * For any interval i, you need to store the minimum interval j's index,
 * which means that the interval j has the minimum start point to build the "right"
 * relationship for interval i. If the interval j doesn't exist, store -1 for the interval i.
 * Finally, you need output the stored value of each interval as an array.
 * <p>
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * Example 1:
 * Input: [ [1,2] ]
 * <p>
 * Output: [-1]
 * <p>
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 * <p>
 * Output: [-1, 0, 1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 * <p>
 * Output: [-1, 2, -1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 */
public class Q436 {

    public int[] findRightInterval(Interval[] intervals) {
        int len = intervals.length;
        int[] res = new int[len];
        TreeMap<Integer, Integer> m = new TreeMap<>();

        for (int i = 0; i < len; i++) {
            m.put(intervals[i].start, i);
        }

        for (int i = 0; i < len; i++) {
            int end = intervals[i].end;
            if (m.containsKey(end)) {
                res[i] = m.get(end);
            } else {
                Map.Entry<Integer, Integer> e = m.higherEntry(end);
                res[i] = e == null ? -1 : e.getValue();
            }
        }

        return res;
    }
}
