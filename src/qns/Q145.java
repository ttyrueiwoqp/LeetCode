package qns;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by LU-PC on 6/10/2015.
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Q145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;

		do {
			while (curr != null) {
				if (curr.right != null) {
					stack.push(curr.right);
				}
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			if (curr.right != null && curr.right == stack.peek()) {
				stack.pop();
				stack.push(curr);
				curr = curr.right;
			} else {
				res.add(curr.val);
				curr = null;
			}

		} while (!stack.isEmpty());

		return res;
	}

	@Test
	public void test() {
		TreeNode[] treeNodes = new TreeNode[8];
		for (int i = 0; i < treeNodes.length; i++) {
			treeNodes[i] = new TreeNode(i);
		}

		treeNodes[0].left = treeNodes[1];
		treeNodes[1].right = treeNodes[2];
		treeNodes[1].left = treeNodes[3];
		treeNodes[3].left = treeNodes[4];
		treeNodes[0].right = treeNodes[5];
		treeNodes[5].left = treeNodes[6];
		treeNodes[2].right = treeNodes[7];

		System.out.println(postorderTraversal(treeNodes[0]));
	}
}
