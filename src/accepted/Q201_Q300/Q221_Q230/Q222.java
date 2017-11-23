package accepted.Q201_Q300.Q221_Q230;

import org.junit.Test;
import util.TreeNode;

/**
 * Created by LU-PC on 7/3/2015.
 * <p>
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class Q222 {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h = calcHeight(root);
		return binarySearch(root, h, 1);
	}

	private int calcHeight(TreeNode root) {
		TreeNode curr = root;
		int h = 1;
		while (curr.left != null) {
			curr = curr.left;
			h++;
		}
		return h;
	}

	private int binarySearch(TreeNode node, int h, int cnt) {
		if (h == 1) {
			return cnt;
		}
		if (node.right == null) {
			return node.left == null ? cnt * 2 - 1 : cnt * 2;
		}

		int currH = 1;
		TreeNode curr = node.left;

		while (curr != null) {
			curr = curr.right;
			currH++;
		}

		if (currH < h) {
			return binarySearch(node.left, h - 1, cnt * 2);
		} else {
			return binarySearch(node.right, h - 1, cnt * 2 + 1);
		}
	}

	@Test
	public void test() {

		TreeNode[] a = new TreeNode[13];
		for (int i = 0; i < a.length; i++) {
			a[i] = new TreeNode(i);
		}
		a[1].left = a[2];
		a[1].right = a[3];
		a[2].left = a[4];
		a[2].right = a[5];
		a[3].left = a[6];
		a[3].right = a[7];
		a[4].left = a[8];
		a[4].right = a[9];
//		a[5].left = a[10];
//		a[5].right = a[11];
//		a[6].left = a[12];



		System.out.println(countNodes(a[1]));
	}

}
