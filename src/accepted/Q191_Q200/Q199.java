package accepted.Q191_Q200;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by LU-PC on 6/5/2015.
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 */
public class Q199 {
	public List<Integer> rightSideView(TreeNode root) {
		Map<Integer, Integer> m = new TreeMap<>();
		traverse(root, 0, m);
		return new ArrayList<>(m.values());
	}

	private void traverse(TreeNode node, int level, Map<Integer, Integer> m) {
		if (node == null) {
			return;
		}
		m.put(level, node.val);
		traverse(node.left, level + 1, m);
		traverse(node.right, level + 1, m);
	}

	@Test
	public void testName() throws Exception {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);

		a1.left = a2;
		a2.right = a5;
		a1.right = a3;
		a3.right = a4;

		System.out.println(rightSideView(a1));

	}

}
