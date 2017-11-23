package accepted.Q101_Q200.Q121_Q130;

import org.junit.Test;
import util.TreeNode;

/**
 * Created by LU-PC on 7/6/2015.
 * <p>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 */
public class Q129 {
	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	private int sum(TreeNode node, int parentVal) {
		if (node == null) {
			return 0;
		}
		int val = parentVal * 10 + node.val;
		if (node.left == null && node.right == null) {
			return val;
		}
		return sum(node.left, val) + sum(node.right, val);
	}

	@Test
	public void test() {
		TreeNode a = new TreeNode(1);
//		TreeNode b = new TreeNode(0);
//		a.left = b;
		System.out.println(sumNumbers(a));
	}
}
