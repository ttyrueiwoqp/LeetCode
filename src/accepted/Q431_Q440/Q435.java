package accepted.Q431_Q440;

import util.Interval;

import java.util.Arrays;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to
 * remove to make the rest of the intervals non-overlapping.
 * <p>
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * Example 1:
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * Output: 1
 * <p>
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 * Input: [ [1,2], [1,2], [1,2] ]
 * <p>
 * Output: 2
 * <p>
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 * Input: [ [1,2], [2,3] ]
 * <p>
 * Output: 0
 * <p>
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class Q435 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (o1, o2) -> (o1.end - o2.end));

        int res = 0, end = Integer.MIN_VALUE;
        for (Interval i : intervals) {
            if (i.start >= end) {
                end = i.end;
            } else {
                res++;
            }
        }

        return res;
    }
}
