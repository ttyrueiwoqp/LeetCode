package accepted.Q031_Q040;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ? a2 ? … ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class Q039 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates.length == 0) {
			return res;
		}

		return combine(candidates, target, 0);
	}

	public List<List<Integer>> combine(int[] candidates, int target, int min) {
		List<List<Integer>> res = new ArrayList<>();

		for (int candidate : candidates) {
			if (candidate < min) {
				continue;
			}
			int diff = target - candidate;
			if (diff == 0) {
				List<Integer> sub = new ArrayList<>();
				sub.add(candidate);
				res.add(sub);
			} else if (diff > 0) {
				List<List<Integer>> subList = combine(candidates, diff, candidate);
				for (List<Integer> sub : subList) {
					sub.add(0, candidate);
				}
				res.addAll(subList);
			}
		}

		return res;
	}

	@Test
	public void test() {
		int[] t = {8,7,4,3};
		System.out.println(combinationSum(t, 11));
	}

}
