package accepted.Q001_Q100.Q091_Q100;

import org.junit.Test;
import util.TreeNode;

/**
 * Created by LU-PC on 7/3/2015.
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * <p>
 * <p>
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * <p>
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
public class Q098 {

	public boolean isValidBST(TreeNode root) {
		return root == null
				|| (isValidLeftBST(root.left, root.val) && isValidRightBST(root.right, root.val));
	}

	private boolean isValidLeftBST(TreeNode root, int maxVal) {
		return root == null
				|| (root.val < maxVal && isValidLeftBST(root.left, root.val) && isValidMidBST(root.right, root.val, maxVal));
	}

	private boolean isValidMidBST(TreeNode root, int minVal, int maxVal) {
		return root == null
				|| (root.val > minVal && root.val < maxVal && isValidMidBST(root.left, minVal, root.val) && isValidMidBST(root.right, root.val, maxVal));
	}

	private boolean isValidRightBST(TreeNode root, int minVal) {
		return root == null
				|| (root.val > minVal && isValidMidBST(root.left, minVal, root.val) && isValidRightBST(root.right, root.val));
	}


	@Test
	public void test() {
		TreeNode[] a = new TreeNode[13];
		for (int i = 0; i < a.length; i++) {
			a[i] = new TreeNode(i);
		}
		a[2].left = a[1];
		a[2].right = a[3];
		a[3].right = a[4];
//		a[2].right = a[5];
//		a[3].left = a[6];
//		a[3].right = a[7];
//		a[4].left = a[8];
//		a[4].right = a[9];

		System.out.println(isValidBST(a[2]));
	}
}
