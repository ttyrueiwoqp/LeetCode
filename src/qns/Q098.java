package qns;

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


		return false;
	}

	@Test
	public void test() {

	}
}
