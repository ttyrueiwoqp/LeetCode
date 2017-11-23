package accepted.Q101_Q200.Q121_Q130;

import org.junit.Test;
import util.TreeNode;

/**
 * Created by LU-PC on 7/6/2015.
 * <p>
 * Given a binary tree, find the maximum path sum.
 * <p>
 * The path may start and end at any node in the tree.
 * <p>
 * For example:
 * Given the below binary tree,
 * <p>
 * 1
 * / \
 * 2   3
 * Return 6.
 */
public class Q124 {

	public int maxPathSum(TreeNode root) {
		TreeNode max = new TreeNode(Integer.MIN_VALUE);
		nodeMax(root, max);
		return max.val;
	}

	private int nodeMax(TreeNode node, TreeNode max) {
		if (node == null) {
			return 0;
		}
		int left = Math.max(nodeMax(node.left, max), 0);
		int right = Math.max(nodeMax(node.right, max), 0);
		max.val = Math.max(max.val, node.val + left + right);
		return node.val + Math.max(left, right);
	}

	@Test
	public void test() {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(-1);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(maxPathSum(a));
	}

}
