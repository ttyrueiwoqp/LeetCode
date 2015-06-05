package accepted.Q071_Q080;

import org.junit.Test;

import java.util.*;

/**
 * Created by LU-PC on 6/4/2015.
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Q078 {
	public List<List<Integer>> subsets(int[] nums) {

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
		for (List<Integer> t1 : tail) {
			List<Integer> t2 = new ArrayList<>(t1);
			t2.add(head);
			res.add(t2);
		}

		res.addAll(tail);
		return res;
	}


	@Test
	public void test() {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		int idx = 3;


		int[] nums = {4,1,0 };
		System.out.println(subsets(nums));

	}

}
