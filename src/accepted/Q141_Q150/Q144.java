package accepted.Q141_Q150;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by LU-PC on 6/10/2015.
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Q144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			res.add(t.val);
			if (t.right != null) {
				stack.push(t.right);
			}
			if (t.left != null) {
				stack.push(t.left);
			}
		}
		return res;
	}

	@Test
	public void test() {
		TreeNode[] treeNodes = new TreeNode[5];
		for (int i = 0; i < treeNodes.length; i++) {
			treeNodes[i] = new TreeNode(i);
		}

		treeNodes[0].left = treeNodes[1];
		treeNodes[1].right = treeNodes[2];
		treeNodes[1].left = treeNodes[3];
		treeNodes[3].left = treeNodes[4];

		System.out.println(preorderTraversal(treeNodes[0]));
	}
}
