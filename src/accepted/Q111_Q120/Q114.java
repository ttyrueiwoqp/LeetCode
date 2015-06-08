package accepted.Q111_Q120;

import org.junit.Test;
import util.TreeNode;

/**
 * Created by LU-PC on 6/5/2015.
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example,
 * Given
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * click to show hints.
 * <p>
 * Hints:
 * If you notice carefully in the flattened tree,
 * each node's right child points to the next node of a pre-order traversal.
 */
public class Q114 {
	public void flatten(TreeNode root) {
		traverse(root);
	}

	private TreeNode traverse(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.left == null) {
			node.right = traverse(node.right);
			return node;
		}

		TreeNode temp = node.right;
		node.right = traverse(node.left);
		node.left = null;
		TreeNode currRight = node.right;
		while (currRight.right != null) {
			currRight = currRight.right;
		}
		currRight.right = traverse(temp);

		return node;
	}

	@Test
	public void test() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);

		t1.left = t2;
		t2.left = t3;
		t2.right = t4;
		t1.right = t5;
		t5.right = t6;

		flatten(t1);
	}
}
