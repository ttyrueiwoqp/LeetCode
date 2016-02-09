package accepted.Q321_Q330;

import org.junit.Test;

/**
 * Created by FJ on 2/9/2016.
 * <p/>
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p/>
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * <p/>
 * Note:
 * You may assume all input has valid answer.
 * <p/>
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Q324 {

	public void wiggleSort(int[] nums) {

		int mid = kthSmallest(nums, (nums.length + 1) / 2, 0, nums.length - 1);

		int i = 0, j = 0, k = nums.length - 1;
		while (j <= k) {
			if (nums[get(nums, j)] > mid) {
				swap(nums, get(nums, i++), get(nums, j++));
			} else if (nums[get(nums, j)] < mid) {
				swap(nums, get(nums, j), get(nums, k--));
			} else {
				j++;
			}
		}

//		System.out.println(mid);
//		for (int m = 0; m < nums.length; m++) {
//			System.out.print(nums[m] + " ");
//		}
//		System.out.println();
	}

	private int get(int[] nums, int i) {
		return (2 * i + 1) % (nums.length | 1);
	}

	private int kthSmallest(int[] nums, int k, int st, int end) {
		if (k < 0 && k > end - st + 1) {
			return -1;
		}

		int pos = partition(nums, st, end);
		if (pos - st == k - 1) {
			return nums[pos];
		} else if (pos - st > k - 1) {
			return kthSmallest(nums, k, st, pos - 1);
		} else {
			return kthSmallest(nums, k - 1 - pos + st, pos + 1, end);
		}
	}

	private int partition(int[] nums, int st, int end) {
		int idx = st;
		for (int i = st; i < end; i++) {
			if (nums[i] <= nums[end]) {
				swap(nums, i, idx);
				idx++;
			}
		}
		swap(nums, idx, end);
		return idx;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	@Test
	public void test() {
		int[] a = {1, 5, 1, 1, 6, 4};
		int[] b = {1, 3, 2, 2, 3, 1};
		int[] c = {4, 5, 5, 6};
		wiggleSort(a);
		wiggleSort(b);
		wiggleSort(c);
	}
}
