package qns;

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
		TreeNode max = new TreeNode(0);
		return nodeMax(root, max);
	}

	private int nodeMax(TreeNode node, TreeNode max) {
		if (node == null) {
			return 0;
		}
		int left = nodeMax(node.left, max);
		int right = nodeMax(node.right, max);
		max.val = Math.max(max.val, node.val + left + right);
		return node.val + Math.max(left, right);

	}

	@Test
	public void test() {
		TreeNode a = new TreeNode(1);
//		TreeNode b = new TreeNode(0);
//		a.left = b;
		System.out.println(maxPathSum(a));
	}

}
