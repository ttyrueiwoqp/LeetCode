package accepted.Q331_Q340;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FJ on 3/19/2016.
 * <p/>
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p/>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p/>
 * Example 1:
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class Q337 {

	public int rob(TreeNode root) {
		int[] a = helper(root);
		return getMax(a);
	}

	private int[] helper(TreeNode root) {
		int[] res = new int[2];
		if (root == null) {
			return res;
		}

		int[] left = helper(root.left);
		int[] right = helper(root.right);

		res[0] = getMax(left) + getMax(right);
		res[1] = root.val + left[0] + right[0];

		return res;
	}

	private int getMax(int[] a) {
		return Math.max(a[0], a[1]);
	}


}
