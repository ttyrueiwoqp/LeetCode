package accepted.Q201_Q300.Q251_Q260;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Implement an iterator to flatten a 2d vector.
 * <p>
 * For example,
 * Given 2d vector =
 * <p>
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * <p>
 * Hint:
 * <p>
 * How many variables do you need to keep track?
 * Two variables is all you need. Try with x and y.
 * Beware of empty rows. It could be the first few rows.
 * To write correct code, think about the invariant to maintain. What is it?
 * The invariant is x and y must always point to a valid point in the 2d vector.
 * Should you maintain your invariant ahead of time or right when you need it?
 * Not sure? Think about how you would implement hasNext(). Which is more complex?
 * Common logic in two different places should be refactored into a common method.
 * Follow up:
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Q251 implements Iterator<Integer> {

    private Iterator<List<Integer>> it = null;
    private Iterator<Integer> it2 = null;

    public Q251(List<List<Integer>> vec2d) {
        if (vec2d == null) {
            return;
        }
        it = vec2d.iterator();
        if (it.hasNext()) {
            it2 = it.next().iterator();
        }
    }

    @Override
    public Integer next() {
        if (it == null || it2 == null || !it2.hasNext()) {
            return null;
        }
        return it2.next();
    }

    @Override
    public boolean hasNext() {
        if (it == null || it2 == null) {
            return false;
        }
        if (it2.hasNext()) {
            return true;
        } else {
            while (it.hasNext()) {
                it2 = it.next().iterator();
                if (it2.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }
}


/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

class Vector2D implements Iterator<Integer>{

    Queue<Iterator<Integer>> queue;
    Iterator<Integer> current = null;

    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        for (int i = 0; i < vec2d.size(); i++) {
            queue.add(vec2d.get(i).iterator());
        }
        current = queue.poll(); // first
    }

    @Override
    public Integer next() {
        if (!current.hasNext()) return -1;

        return current.next();
    }

    @Override
    public boolean hasNext() {
        if (current == null) return false;

        while (!current.hasNext()) {
            if (!queue.isEmpty()) {
                current = queue.poll();
            } else return false;
        }

        return true;
    }
}