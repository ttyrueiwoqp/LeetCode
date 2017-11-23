package accepted.Q101_Q200.Q101_Q110;

import org.junit.Test;
import util.TreeNode;

/**
 * Created by LU-PC on 6/17/2015.
 * <p>
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class Q108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] nums, int st, int end) {
		int mid = (st + end) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		if (st < mid) {
			root.left = sortedArrayToBST(nums, st, mid - 1);
		}
		if (mid < end) {
			root.right = sortedArrayToBST(nums, mid + 1, end);
		}
		return root;
	}

	@Test
	public void test() {
	}
}
