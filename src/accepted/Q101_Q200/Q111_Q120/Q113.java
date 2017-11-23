package accepted.Q101_Q200.Q111_Q120;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) {

		} else if (root.left == null && root.right == null) {
			if (root.val == sum) {
				List<Integer> el = new ArrayList<Integer>();
				el.add(root.val);
				res.add(el);
			}
		} else {
			List<List<Integer>> left = pathSum(root.left, sum - root.val);
			if (!left.isEmpty()) {
				res.addAll(left);
			}

			List<List<Integer>> right = pathSum(root.right, sum - root.val);
			if (!right.isEmpty()) {
				res.addAll(right);
			}

			for (List<Integer> el : res) {
				el.add(0, root.val);
			}
		}
		return res;
	}

	@Test
	public void test() {

		TreeNode a = new TreeNode(-2);
		TreeNode b = new TreeNode(-3);
		a.right = b;

		System.out.println(pathSum(a, -5));

	}

}
