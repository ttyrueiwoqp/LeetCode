package accepted.Q221_Q230;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 7/2/2015.
 * <p>
 * Given an integer array of size n,
 * find all elements that appear more than ? n/3 ? times.
 * The algorithm should run in linear time and in O(1) space.
 * <p>
 * Hint:
 * <p>
 * How many majority elements could it possibly have?
 */
public class Q229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums.length == 0) {
			return res;
		}
		int n1 = nums[0], n2 = nums[0], c1 = 0, c2 = 0;
		for (int n : nums) {
			if (n == n1) {
				c1++;
			} else if (n == n2) {
				c2++;
			} else if (c1 == 0) {
				n1 = n;
				c1 = 1;
			} else if (c2 == 0) {
				n2 = n;
				c2 = 1;
			} else {
				c1--;
				c2--;
			}
		}

		c1 = 0;
		c2 = 0;
		for (int num : nums) {
			if (num == n1) {
				c1++;
			} else if (num == n2) {
				c2++;
			}
		}
		if (c1 > nums.length / 3) {
			res.add(n1);
		}
		if (c2 > nums.length / 3) {
			res.add(n2);
		}
		return res;
	}

	@Test
	public void test() {
		int[] a = {1, 1, 2, 3, 3};
		System.out.println(majorityElement(a));
	}
}
