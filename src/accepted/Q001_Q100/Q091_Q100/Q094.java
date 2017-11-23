package accepted.Q001_Q100.Q091_Q100;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by LU-PC on 6/10/2015.
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Q094 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;

		while (!stack.isEmpty() || curr != null) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}

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

		System.out.println(inorderTraversal(treeNodes[0]));
	}
}
