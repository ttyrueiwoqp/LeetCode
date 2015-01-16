package accepted.Q101_Q110;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.TreeNode;

public class Q101 {

	public boolean isSymmetric(TreeNode root) {

		return root == null ? true : isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode p, TreeNode q) {

		List<TreeNode> ps = new ArrayList<TreeNode>();
		List<TreeNode> qs = new ArrayList<TreeNode>();
		ps.add(p);
		qs.add(q);

		int idx = 0;
		boolean isAdded = true;
		while (isAdded) {
			
			if (!compare(ps, qs, idx)) {
				return false;
			}
			
			isAdded = false;
			int size = ps.size();

			for (int i = idx; i < size; i++) {

				if (ps.get(i) != null) {
					ps.add(ps.get(i).left);
					ps.add(ps.get(i).right);
					isAdded = true;
				}
				if (qs.get(i) != null) {
					qs.add(qs.get(i).right);
					qs.add(qs.get(i).left);
					isAdded = true;
				}
			}
			idx = size;
		}

		return true;
	}

	private boolean compare(List<TreeNode> ps, List<TreeNode> qs, int idx) {
		for (int i = idx; i < ps.size(); i++) {
			if ((ps.get(i) == null && qs.get(i) != null)
					|| (ps.get(i) != null && qs.get(i) == null)) {
				return false;
			} else if (ps.get(i) != null && qs.get(i) != null
					&& ps.get(i).val != qs.get(i).val) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(5);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		
		System.out.println(isSymmetric(a));
		
	}

}
