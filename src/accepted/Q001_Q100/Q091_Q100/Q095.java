package accepted.Q001_Q100.Q091_Q100;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 6/12/2015.
 * <p>
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Q095 {
	public List<TreeNode> generateTrees(int n) {

		List<List<TreeNode>> res = new ArrayList<>();

		List<TreeNode> n0 = new ArrayList<>();
		n0.add(null);
		res.add(n0);

		List<TreeNode> n1 = new ArrayList<>();
		n1.add(new TreeNode(1));
		res.add(n1);

		if (n > 1) {
			for (int i = 2; i <= n; i++) {
				for (int j = 0; j < i; j++) {
					List<TreeNode> ls = res.get(j);
					List<TreeNode> rs = res.get(i - j - 1);

					TreeNode t = new TreeNode(1);
					for (TreeNode l : ls) {
						for (TreeNode r : rs) {
							TreeNode td = duplicate(t, j);
							td.left = duplicate(l, 0);
							td.right = duplicate(r, j + 1);
							if (res.size() <= i) {
								res.add(new ArrayList<>());
							}
							res.get(i).add(td);
						}
					}
				}
			}
		}

		return res.get(n);
	}

	public TreeNode duplicate(TreeNode t, int val) {
		if (t == null) {
			return null;
		}
		TreeNode res = new TreeNode(t.val + val);
		res.left = duplicate(t.left, val);
		res.right = duplicate(t.right, val);
		return res;
	}

	@Test
	public void test() {
		List<TreeNode> ts = generateTrees(3);
		System.out.println(ts.size());
		for (TreeNode t : ts) {
			System.out.println(t);
		}
	}
}
