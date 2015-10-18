package accepted.Q251_Q260;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FJ on 10/18/2015.
 * <p/>
 * Given a binary tree, return all root-to-leaf paths.
 * <p/>
 * For example, given the following binary tree:
 * <p/>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p/>
 * ["1->2->5", "1->3"]
 */
public class Q257 {

	public List<String> binaryTreePaths(TreeNode node) {

		List<String> res = new ArrayList<>();
		if (node == null) {
			return res;
		}

		if (node.left == null && node.right == null) {
			res.add(String.valueOf(node.val));
		} else {
			res.addAll(binaryTreePaths(node.left));
			res.addAll(binaryTreePaths(node.right));

			for (int i = 0; i < res.size(); i++) {
				res.set(i, node.val + "->" + res.get(i));
			}
		}
		return res;
	}

	@Test
	public void test() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t5;
		System.out.println(binaryTreePaths(t1));
	}
}
