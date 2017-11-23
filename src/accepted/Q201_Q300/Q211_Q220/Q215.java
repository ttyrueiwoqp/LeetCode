package accepted.Q201_Q300.Q211_Q220;

/**
 * Created by LU-PC on 6/3/2015.
 * <p>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ? k ? array's length.
 */
public class Q215 {
	public int findKthLargest(int[] nums, int k) {
		return kthSmallest(nums, nums.length + 1 - k, 0, nums.length - 1);
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
}
