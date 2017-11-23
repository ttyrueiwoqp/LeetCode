package accepted.Q201_Q300.Q281_Q290;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * <p>
 * For example, given two 1d vectors:
 * <p>
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
 * [1, 3, 2, 4, 5, 6].
 * <p>
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * <p>
 * Clarification for the follow up question - Update (2015-09-18):
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 * <p>
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * It should return [1,4,8,2,5,9,3,6,7].
 */
public class Q281 {

    private List<Iterator<Integer>> its = new ArrayList<>();
    private int idx = 0;
    private boolean hasMore = true;

    public Q281(List<Integer> v1, List<Integer> v2) {
        its.add(v1.iterator());
        its.add(v2.iterator());
    }

    public int next() {
        int res = its.get(idx).next();
        nextIdx();
        return res;
    }

    public boolean hasNext() {
        if (hasMore) {
            int i = 0;
            while (!its.get(idx).hasNext() && i < its.size()) {
                nextIdx();
                i++;
            }
            if (i == its.size()) {
                hasMore = false;
            }
        }
        return its.get(idx).hasNext();
    }

    private void nextIdx() {
        idx++;
        if (idx == its.size()) {
            idx = 0;
        }
    }
}

class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}