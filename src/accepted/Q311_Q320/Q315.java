package accepted.Q311_Q320;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by FJ on 12/6/2015.
 * <p/>
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p/>
 * Example:
 * <p/>
 * Given nums = [5, 2, 6, 1]
 * <p/>
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 */
public class Q315 {

	public List<Integer> countSmaller(int[] nums) {
		int[] tmp = nums.clone();
		Arrays.sort(tmp);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
		}
		int[] bit = new int[nums.length + 1];
		Integer[] ans = new Integer[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			ans[i] = query(bit, nums[i] - 1);
			add(bit, nums[i], 1);
		}
		return Arrays.asList(ans);
	}

	private void add(int[] bit, int i, int val) {
		while (i < bit.length) {
			bit[i] += val;
			i += i & -i;
		}
	}

	private int query(int[] bit, int i) {
		int ans = 0;
		while (i > 0) {
			ans += bit[i];
			i -= i & -i;
		}
		return ans;
	}

	@Test
	public void test() {
		int[] a = {5, 2, 6, 1, 3};
		System.out.println(countSmaller(a));
	}
}
