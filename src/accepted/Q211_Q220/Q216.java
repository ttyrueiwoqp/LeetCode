package accepted.Q211_Q220;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FJ on 11/13/2015.
 * <p/>
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p/>
 * Ensure that numbers within the set are sorted in ascending order.
 * <p/>
 * <p/>
 * Example 1:
 * <p/>
 * Input: k = 3, n = 7
 * <p/>
 * Output:
 * <p/>
 * [[1,2,4]]
 * <p/>
 * Example 2:
 * <p/>
 * Input: k = 3, n = 9
 * <p/>
 * Output:
 * <p/>
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Q216 {

	public List<List<Integer>> combinationSum3(int k, int n) {
		return combinationSum3(k, n, 1);
	}

	public List<List<Integer>> combinationSum3(int k, int n, int start) {

		List<List<Integer>> result = new ArrayList<>();
		if (k <= 0) {
			return result;
		}
		if (k == 1) {
			if (n < 10 && n >= start) {
				List<Integer> list = new ArrayList<>();
				list.add(n);
				result.add(list);
			}
			return result;
		}

		for (int i = start; i < 10; i++) {
			List<List<Integer>> nexts = combinationSum3(k - 1, n - i, i + 1);
			for (List<Integer> next : nexts) {
				next.add(0, i);
			}
			result.addAll(nexts);
		}

		return result;
	}

	@Test
	public void test() {
//		System.out.println(combinationSum3(8, 36));
//		System.out.println(combinationSum3(3, 7));
//		System.out.println(combinationSum3(3, 9));
		System.out.println(combinationSum3(2, 18));
	}
}
