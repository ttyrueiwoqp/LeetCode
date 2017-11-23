package accepted.Q201_Q300.Q291_Q300;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by FJ on 2/13/2016.
 * <p/>
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p/>
 * Examples:
 * [2,3,4] , the median is 3
 * <p/>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p/>
 * Design a data structure that supports the following two operations:
 * <p/>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * <p/>
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3)
 * findMedian() -> 2
 */
public class Q295 {

	@Test
	public void test() {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap.offer(2);
		minHeap.offer(3);
		minHeap.offer(1);
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());

		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		mf.addNum(5);
		mf.addNum(6);
		mf.addNum(7);
		mf.addNum(8);
		System.out.println(mf.findMedian());
	}




}

class MedianFinder {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	// Adds a number into the data structure.
	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
}
