package accepted.Q101_Q110;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by LU-PC on 6/9/2015.
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Q102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Deque<TreeNode> deque = new ArrayDeque<>();
		Deque<Integer> levels = new ArrayDeque<>();
		deque.addLast(root);
		levels.addLast(0);

		while (!deque.isEmpty()) {
			TreeNode node = deque.pollFirst();
			Integer level = levels.pollFirst();

			if (res.size() <= level) {
				res.add(new ArrayList<>());
			}
			res.get(level).add(node.val);

			if (node.left != null) {
				deque.addLast(node.left);
				levels.addLast(level + 1);
			}
			if (node.right != null) {
				deque.addLast(node.right);
				levels.addLast(level + 1);
			}
		}

		return res;
	}

	@Test
	public void test() {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);

		a1.left = a2;
		a2.right = a5;
		a1.right = a3;
		a3.right = a4;

		System.out.println(levelOrder(a1));
	}

}
