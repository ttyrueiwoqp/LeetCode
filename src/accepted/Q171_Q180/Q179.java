package accepted.Q171_Q180;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 6/2/2015.
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Q179 {
	public String largestNumber(int[] nums) {

		List<String> strs = new ArrayList<>();

		for (int num : nums) {
			String curr = Integer.toString(num);
			boolean hasAdded = false;
			for (int i = 0; i < strs.size(); i++) {
				if (isGreater(curr, strs.get(i))) {
					strs.add(i, curr);
					hasAdded = true;
					break;
				}
			}
			if (!hasAdded) {
				strs.add(curr);
			}
		}

		if (strs.get(0).equals("0")) {
			return "0";
		}

		StringBuilder res = new StringBuilder();
		for (String s : strs) {
			res.append(s);
		}

		return res.toString();
	}

	private boolean isGreater(String s1, String s2) {
		int p = 0, q = 0;
		while (!(p == s1.length() && q == s2.length())) {
			if (p == s1.length()) {
				p = 0;
			} else if (q == s2.length()) {
				q = 0;
			}

			if (s1.charAt(p) == s2.charAt(q)) {
				p++;
				q++;
			} else {
				return s1.charAt(p) > s2.charAt(q);
			}
		}
		return false;
	}

	@Test
	public void test() {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));
	}
}
