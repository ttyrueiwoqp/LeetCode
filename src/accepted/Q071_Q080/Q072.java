package accepted.Q071_Q080;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given two words word1 and word2, find the minimum number of steps required
 * to convert word1 to word2. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class Q072 {

	public int minDistance(String word1, String word2) {
		int[] d = new int[word2.length() + 1];
		for (int i = 0; i <= word2.length(); ++i) {
			d[i] = i;
		}
		for (int i = 1; i <= word1.length(); ++i) {
			int prev = d[0];
			d[0] = i;
			for (int j = 1; j <= word2.length(); ++j) {
				int tmp = d[j];
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					d[j] = prev;
				} else {
					d[j] = Math.min(Math.min(d[j - 1], d[j]), prev) + 1;
				}
				prev = tmp;
			}
		}
		return d[word2.length()];
	}

	private void print(int[] d) {
		for (int i : d) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private int seqLen(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int res = 0;

		Map<Integer, Integer> m = new TreeMap<>();
		m.put(nums[0], 1);
		for (int i = 1; i < nums.length; i++) {
			Integer prevLen = m.get(nums[i - 1]);
			Integer currLen = m.get(nums[i]);

			if (nums[i] == nums[i - 1]) {
				currLen = Math.max(currLen, prevLen);
			} else {
				if (currLen == null) {
					m.put(nums[i], 0);
				}
				List<Integer> keys = new ArrayList<>(m.keySet());
				Integer prevKey = keys.get((keys.indexOf(nums[i])) - 1);
				currLen = m.get(prevKey) + 1;
			}

			res = Math.max(res, currLen);
			m.put(nums[i], currLen);
		}

		System.out.println(m);

		return res;
	}

	@Test
	public void test() {
//		int[] a = {0, 1, 3, 8, 5, 9, 11,};
//		System.out.println(seqLen(a));

		minDistance("ros", "horse");
	}

}
