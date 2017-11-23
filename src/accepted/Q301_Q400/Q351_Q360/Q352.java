package accepted.Q301_Q400.Q351_Q360;

import util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ...,
 * summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ...,
 * then the summary will be:
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * Follow up:
 * What if there are lots of merges and the number of disjoint
 * intervals are small compared to the data stream's size?
 */
public class Q352 {

    TreeMap<Integer, Interval> m;

    /**
     * Initialize your data structure here.
     */
    public Q352() {
        m = new TreeMap<>();
    }

    public void addNum(int val) {
        if (m.containsKey(val)) {
            return;
        }

        Integer low = m.lowerKey(val);
        Integer high = m.higherKey(val);

        if (low != null && m.get(low).end == val - 1
                && high != null && high == val + 1) {
            m.get(low).end = m.get(high).end;
            m.remove(high);

        } else if (low != null && m.get(low).end >= val - 1) {
            m.get(low).end = Math.max(m.get(low).end, val);

        } else if (high != null && high == val + 1) {
            m.put(val, new Interval(val, m.get(high).end));
            m.remove(high);

        } else {
            m.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(m.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
