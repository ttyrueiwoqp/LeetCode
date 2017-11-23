package accepted.Q101_Q200.Q161_Q170;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by FJ on 2/17/2016.
 * <p/>
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p/>
 * Try to solve it in linear time/space.
 * <p/>
 * Return 0 if the array contains less than 2 elements.
 * <p/>
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class Q164 {

	public int maximumGap(int[] nums) {
		int len = nums.length;
		if (len < 2) {
			return 0;
		}
		if (len == 2) {
			return Math.abs(nums[0] - nums[1]);
		}

		int max = nums[0];
		int min = nums[0];
		for (int num : nums) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}

		int gap = (int) Math.ceil((double)(max - min) / (len - 1));
		int[] bucketMin = new int[len - 1];
		int[] bucketMax = new int[len - 1];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);

		for (int num : nums) {
			if (num == min || num == max) {
				continue;
			}
			int idx = (num - min) / gap;
			bucketMin[idx] = Math.min(bucketMin[idx], num);
			bucketMax[idx] = Math.max(bucketMax[idx], num);
		}

		int res = Integer.MIN_VALUE;
		int prev = min;
		for (int i = 0; i < len - 1; i++) {
			if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
				continue;
			}
			res = Math.max(bucketMin[i] - prev, res);
			prev = bucketMax[i];
		}
		res = Math.max(max - prev, res);
		return res;
	}


	public int maximumGap2(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}

		int[][] small = new int[2][nums.length];
		int[][] big = new int[2][nums.length];
		computeGap(nums, small[0], big[0], 1);
		computeGap(nums, small[1], big[1], -1);

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int smallGap = Math.min(small[0][i], small[1][i]);
			if (smallGap == 0) {
				smallGap = Math.max(small[0][i], small[1][i]);
			}
			int bigGap = Math.min(small[0][i], small[1][i]);
			if (bigGap == 0) {
				bigGap = Math.max(small[0][i], small[1][i]);
			}
			max = Math.max(max, Math.max(smallGap, bigGap));
		}

		return max;
	}

	private void computeGap(int[] nums, int[] small, int[] big, int dir) {

		int st = dir == 1 ? 0 : nums.length - 1;
		small[st] = 0;
		big[st] = 0;
		int cnt = 1, i;
		while (cnt < nums.length) {
			i = dir == 1 ? cnt : nums.length - 1 - cnt;
			if (nums[i] >= nums[i - dir] + big[i - dir]) {
				small[i] = nums[i] - (nums[i - dir] + big[i - dir]);
				big[i] = 0;

			} else if (nums[i] >= nums[i - dir]) {
				small[i] = nums[i] - nums[i - dir];
				big[i] = nums[i - dir] + big[i - dir] - nums[i];

			} else if (nums[i] >= nums[i - dir] - small[i - dir]) {
				small[i] = nums[i] - (nums[i - dir] - small[i - dir]);
				big[i] = nums[i - dir] - nums[i];

			} else {
				small[i] = 0;
				big[i] = nums[i - dir] - small[i - dir] - nums[i];
			}
			cnt++;
		}

		print(small);
		print(big);
	}

	private void print(int[] big) {
		for (int i : big) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	@Test
	public void test() {
		int[] a = {15, 6, 8, 4};
		System.out.println(maximumGap(a));

		int[] b = {16, 15, 6, 8, 100};
		System.out.println(maximumGap(b));
	}

}
