package accepted.Q001_Q100.Q081_Q090;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Created by LU-PC on 7/2/2015.
 * <p>
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets.
 * <p>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Q090 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Deque<Integer> deque = new ArrayDeque<>();
		for (int num : nums) {
			deque.add(num);
		}

		List<List<Integer>> res = computeSubsets(deque);
		for (List<Integer> r : res) {
			Collections.sort(r);
		}

		return res;
	}

	private List<List<Integer>> computeSubsets(Deque<Integer> deque) {
		List<List<Integer>> res = new ArrayList<>();

		Integer head = deque.pollLast();
		if (head == null) {
			res.add(new ArrayList<>());
			return res;
		}

		List<List<Integer>> tail = computeSubsets(deque);
		int maxDupCnt = 0;
		int[] dupCnt = new int[tail.size()];
		for (int i = 0; i < dupCnt.length; i++) {
			dupCnt[i] = checkCnt(tail.get(i), head);
			maxDupCnt = Math.max(maxDupCnt, dupCnt[i]);
		}
		for (int i = 0; i < tail.size(); i++) {
			if (dupCnt[i] == maxDupCnt) {
				List<Integer> t2 = new ArrayList<>(tail.get(i));
				t2.add(head);
				res.add(t2);
			}
		}

		res.addAll(tail);
		return res;
	}

	private int checkCnt(List<Integer> list, Integer head) {
		int cnt = 0;
		for (Integer i : list) {
			if (i.equals(head)) {
				cnt++;
			}
		}
		return cnt;
	}


	@Test
	public void test() {
		int[] nums = {1, 2, 2};
		System.out.println(subsetsWithDup(nums));
	}
}
