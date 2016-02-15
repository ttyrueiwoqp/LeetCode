package accepted.Q231_Q240;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by FJ on 2/15/2016.
 * <p/>
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * <p/>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p/>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * <p/>
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * <p/>
 * Follow up:
 * Could you solve it in linear time?
 */
public class Q239 {

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n == 0) {
			return new int[0];
		}
		if (k == 1) {
			return nums;
		}

		int[] res = new int[n - k + 1];

		Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> idxs = new ArrayDeque<>();
		deque.addFirst(nums[0]);
		idxs.addFirst(0);

		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			if (idxs.peekFirst() + k == i) {
				deque.pollFirst();
				idxs.pollFirst();
			}

			if (nums[i] >= deque.peekFirst()) {
				deque.clear();
				idxs.clear();
				deque.addFirst(nums[i]);
				idxs.addFirst(i);
			} else {
				while (deque.peekLast() <= nums[i]) {
					deque.pollLast();
					idxs.pollLast();
				}
				deque.addLast(nums[i]);
				idxs.addLast(i);
			}

			if (i >= k - 1) {
				res[j] = deque.peekFirst();
				j++;
			}
		}
		return res;
	}

	@Test
	public void test() {
//		int[] a = {1,3,-1,-3,5,3,6,7};
//		print(maxSlidingWindow(a, 3));

		int[] b = {9,10,9,-7,-4,-8,2,-6};
		print(maxSlidingWindow(b, 5));


	}

	public void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
