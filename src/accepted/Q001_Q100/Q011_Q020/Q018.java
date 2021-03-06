package accepted.Q001_Q100.Q011_Q020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
public class Q018 {

	public List<List<Integer>> fourSum(int[] num, int target) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (num == null || num.length < 4) {
			return res;
		}
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < num.length; j++) {
				if (j > i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				int k = j + 1, m = num.length - 1;
				while (k < m) {
					if (k > j + 1 && num[k] == num[k - 1]) {
						k++;
						continue;
					}
					if (m < num.length - 1 && num[m] == num[m + 1]) {
						m--;
						continue;
					}
					int sum = num[i] + num[j] + num[k] + num[m];
					if (sum == target) {
						List<Integer> item = new ArrayList<Integer>();
						item.add(num[i]);
						item.add(num[j]);
						item.add(num[k]);
						item.add(num[m]);
						res.add(item);
						k++;
					} else if (sum > target) {
						m--;
					} else {
						k++;
					}
				}
			}
		}

		return res;
	}

	@Test
	public void test() {

		List<Integer> m = Arrays.asList(-1, 0, 0, 1);
		List<Integer> n = Arrays.asList(-2, -1, 1, 2);
		List<Integer> o = Arrays.asList(-2, 0, 0, 2);

		List<List<Integer>> a = new ArrayList<List<Integer>>();
		a.add(m);
		a.add(n);
		a.add(o);

		int[] s = {1, 0, -1, 0, -2, 2};
		assertEquals(a, fourSum(s, 0));
	}

}
