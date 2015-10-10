package accepted.Q281_Q290;

import java.util.*;

/**
 * Created by FJ on 10/10/2015.
 * <p/>
 * Given an Iterator class interface with methods: next() and hasNext(),
 * design and implement a PeekingIterator that support the peek() operation
 * -- it essentially peek() at the element that will be returned by the next call to next().
 * <p/>
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * <p/>
 * Call next() gets you 1, the first element in the list.
 * <p/>
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * <p/>
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class Q284 implements Iterator<Integer> {

	private Iterator<Integer> iterator;
	private Integer curr;

	public Q284(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
		curr = iterator.hasNext() ? iterator.next() : null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return curr;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (curr == null) {
			return iterator.next();
		}
		Integer temp = curr;
		curr = iterator.hasNext() ? iterator.next() : null;
		return temp;
	}

	@Override
	public boolean hasNext() {
		return curr != null;
	}
}
