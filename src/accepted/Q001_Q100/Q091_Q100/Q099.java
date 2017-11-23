package accepted.Q001_Q100.Q091_Q100;

import util.TreeNode;

/**
 * Created by FJ on 3/9/2016.
 * <p/>
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p/>
 * Recover the tree without changing its structure.
 * <p/>
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * <p/>
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * <p/>
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * <p/>
 * Here's an example:
 * 1
 * / \
 * 2   3
 * /
 * 4
 * \
 * 5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class Q099 {

	private TreeNode first = null;
	private TreeNode second = null;
	private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {
		traverse(root);
		swap(first, second);
	}

	private void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		traverse(root.left);

		if (root.val <= prev.val) {
			if (first == null) {
				first = prev;
			}
			second = root;
		}

		prev = root;
		traverse(root.right);
	}

	private void swap(TreeNode first, TreeNode second) {
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
}
