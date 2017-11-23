package accepted.Q101_Q200.Q101_Q110;

import org.junit.Test;
import util.TreeNode;

public class Q104 {
	
	public int maxDepth(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

	}

	@Test
	public void test() {
	}

}
