package accepted.Q251_Q260;

import org.junit.Test;
import util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * <p>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
public class Q253 {

    public int minMeetingRooms(Interval[] intervals) {

        int res = 0, cnt = 0;

        Interval[] starts = Arrays.copyOf(intervals, intervals.length);
        Interval[] ends = Arrays.copyOf(intervals, intervals.length);

        Arrays.sort(starts, (o1, o2) -> o1.start - o2.start);
        Arrays.sort(ends, (o1, o2) -> o1.end - o2.end);

        int i = 0, j = 0;
        while (i < starts.length) {
            if (starts[i].start < ends[j].end) {
                i++;
                cnt++;
                res = Math.max(res, cnt);
            } else {
                j++;
                cnt--;
            }
        }

        return res;
    }

    @Test
    public void test() {
        Interval[] a = new Interval[3];
        a[0] = new Interval(0, 30);
        a[1] = new Interval(5,10);
        a[2] = new Interval(15,20);
        System.out.println(minMeetingRooms(a));
    }


    public int sln(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }
}
