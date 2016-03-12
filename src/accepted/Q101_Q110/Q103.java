package accepted.Q101_Q110;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by FJ on 3/12/2016.
 * <p/>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Q103 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		List<Integer> list;
		Deque<TreeNode> s1 = new ArrayDeque<>();
		Deque<TreeNode> s2 = new ArrayDeque<>();
		s1.push(root);

		while (!s1.isEmpty()) {

			list = new ArrayList<>();
			while (!s1.isEmpty()) {
				TreeNode temp = s1.pop();
				list.add(temp.val);
				if (temp.left != null) {
					s2.push(temp.left);
				}
				if (temp.right != null) {
					s2.push(temp.right);
				}
			}
			if (!list.isEmpty()) {
				res.add(list);
			}

			list = new ArrayList<>();
			while (!s2.isEmpty()) {
				TreeNode temp = s2.pop();
				list.add(temp.val);
				if (temp.right != null) {
					s1.push(temp.right);
				}
				if (temp.left != null) {
					s1.push(temp.left);
				}
			}
			if (!list.isEmpty()) {
				res.add(list);
			}
		}

		return res;
	}


	@Test
	public void test() {
		TreeNode node = new TreeNode(1);
		System.out.println(zigzagLevelOrder(node));
	}
}
