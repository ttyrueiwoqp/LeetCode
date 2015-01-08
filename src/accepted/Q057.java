package accepted;

import java.util.ArrayList;

import util.Interval;

public class Q057 {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {

		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval growInterval = new Interval(newInterval.start, newInterval.end);
		boolean stop = false;

		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = new Interval(intervals.get(i).start,
					intervals.get(i).end);

			if (stop || growInterval.start > interval.end) {
				result.add(interval);

			} else if (growInterval.end < interval.start) {
				stop = true;
				result.add(growInterval);
				result.add(interval);

			} else {
				growInterval = new Interval(Math.min(growInterval.start,
						interval.start), Math.max(growInterval.end,
						interval.end));
			}
		}

		if (!stop) {
			result.add(growInterval);
		}

		return result;
	}

}
