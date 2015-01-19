package accepted.Q111_Q120;

import static org.junit.Assert.*;

import org.junit.Test;

import util.TreeNode;

public class Q112 {

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		} else if (root.val == sum && root.left == null && root.right == null) {
			return true;
		} else {
			return hasPathSum(root.left, sum - root.val)
					|| hasPathSum(root.right, sum - root.val);
		}

	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
