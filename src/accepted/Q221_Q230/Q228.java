package accepted.Q221_Q230;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FJ on 6/27/2015.
 * <p/>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p/>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class Q228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			boolean hasRange = false;
			StringBuilder sb = new StringBuilder();
			sb.append(nums[i]);
			while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
				i++;
				hasRange = true;
			}
			if (hasRange) {
				sb.append("->").append(nums[i]);
			}
			res.add(sb.toString());
		}
		return res;
	}

	@Test
	public void test() {
		int[] a = {0,1,2,4,5,7};
		System.out.println(summaryRanges(a));
	}
}
