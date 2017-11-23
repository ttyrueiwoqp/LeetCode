package accepted.Q201_Q300.Q231_Q240;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 10/9/2015.
 * <p/>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p/>
 * According to the definition of LCA on Wikipedia: �The lowest common ancestor is defined between two nodes
 * v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).�
 * <p/>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 * Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class Q236 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> res = new ArrayList<>();
		traverse(root, p, q, res);
		return res.get(0);
	}

	private int traverse(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> res) {
		if (node == null) {
			return 0;
		}

		int sum = traverse(node.left, p, q, res) + traverse(node.right, p, q, res);
		if (node == p || node == q) {
			sum += 1;
		}
		if (sum == 2) {
			res.add(node);
			return 3;
		}
		return sum;
	}

	@Test
	public void test() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;

		System.out.println(lowestCommonAncestor(t1, t1, t2));
	}

}
