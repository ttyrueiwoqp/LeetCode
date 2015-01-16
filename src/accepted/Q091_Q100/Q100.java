package accepted.Q091_Q100;

import static org.junit.Assert.*;

import org.junit.Test;

import util.TreeNode;

public class Q100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		if (p == null && q == null) {
			return true;
		} else if ((p != null && q == null) || (p == null && q != null)) {
			return false;
		}
		
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
