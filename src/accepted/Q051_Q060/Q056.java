package accepted.Q051_Q060;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import util.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class Q056 {

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals.size() == 0) {
			return res;
		}

		Map<Integer, Interval> m = new TreeMap<>();
		for (Interval interval : intervals) {
			Interval val = m.get(interval.start);
			if (val != null) {
				interval.end = Math.max(interval.end, val.end);
			}
			m.put(interval.start, interval);
		}

		Interval curr = null;
		for (Map.Entry<Integer, Interval> entry : m.entrySet()) {
			Interval interval = entry.getValue();
			if (curr != null) {
				if (interval.start > curr.end) {
					res.add(curr);
					curr = interval;
				} else {
					curr.end = Math.max(interval.end, curr.end);
				}
			} else {
				curr = interval;
			}
		}
		res.add(curr);
		return res;
	}

	@Test
	public void test() {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(2, 2));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(5, 5));
		System.out.println(merge(intervals));
	}

}
