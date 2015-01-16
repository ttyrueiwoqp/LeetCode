package accepted.Q101_Q110;

import static org.junit.Assert.*;

import org.junit.Test;

import util.TreeNode;

public class Q110 {

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		} else {
			return false;
		}

	}

	private int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(depth(node.left), depth(node.right)) + 1;
	}
	
//	public boolean isBalanced(TreeNode root) {
//        return root == null || balance(root, 1) > 0;
//    }
//    
//    private int balance(TreeNode node, int level) {
//        int l = node.left != null ? balance(node.left, level+1) : level;
//        int r = node.right != null ? balance(node.right, level+1) : level;
//        if (l == -1 || r == -1 || Math.abs(r - l) > 1) return -1;
//        return Math.max(l, r);
//    }

	@Test
	public void test() {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(5);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;

		assertEquals(3, depth(a));
		assertEquals(2, depth(b));
		assertEquals(1, depth(d));
		assertEquals(1, depth(f));
		assertTrue(isBalanced(a));
	}

}
