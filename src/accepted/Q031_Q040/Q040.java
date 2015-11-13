package accepted.Q031_Q040;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by LU-PC on 6/17/2015.
 * <p>
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ..., ak) must be in non-descending order. (ie, a1 ? a2 ? ... ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class Q040 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates.length == 0) {
			return res;
		}
		Map<Integer, Integer> m = new HashMap<>();
		for (int candidate : candidates) {
			Integer cnt = m.get(candidate);
			if (cnt == null) {
				cnt = 0;
			}
			m.put(candidate, ++cnt);
		}

		return combine(m, target, 0);
	}

	public List<List<Integer>> combine(Map<Integer, Integer> m, int target, int min) {
		List<List<Integer>> res = new ArrayList<>();

		for (Map.Entry<Integer, Integer> entry : m.entrySet()) {

			int candidate = entry.getKey();
			int cnt = entry.getValue();
			if (candidate < min || cnt == 0) {
				continue;
			}

			int diff = target - candidate;
			if (diff == 0) {
				List<Integer> sub = new ArrayList<>();
				sub.add(candidate);
				res.add(sub);
			} else if (diff > 0) {
				Map<Integer, Integer> mCopy = new HashMap<>();
				mCopy.putAll(m);
				mCopy.put(candidate, cnt - 1);
				List<List<Integer>> subList = combine(mCopy, diff, candidate);
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
		int[] tt = {2,3,6,7};
		System.out.println(combinationSum2(tt, 7));
		int[] t = {10,1,2,7,6,1,5};
		System.out.println(combinationSum2(t, 8));
	}
}
