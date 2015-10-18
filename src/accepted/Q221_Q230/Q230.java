package accepted.Q221_Q230;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by FJ on 10/18/2015.
 * <p/>
 * Given a binary search tree, write a function kthSmallest
 * to find the kth smallest element in it.
 * <p/>
 * Note:
 * You may assume k is always valid, 1 ? k ? BST's total elements.
 * <p/>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often
 * and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class Q230 {

	public int kthSmallest(TreeNode root, int k) {

		Deque<TreeNode> stack = new ArrayDeque<>();

		TreeNode curr = root;
		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}

		int res = stack.peek().val;
		for (int i = 0; i < k; i++) {
			res = next(stack);
		}

		return res;
	}

	public int next(Deque<TreeNode> stack) {
		TreeNode res = stack.pop();
		TreeNode curr = res.right;
		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
		return res.val;
	}

	@Test
	public void test() {
		TreeNode[] a = new TreeNode[13];
		for (int i = 0; i < a.length; i++) {
			a[i] = new TreeNode(i);
		}
		a[2].left = a[1];
		a[2].right = a[3];
		a[3].right = a[4];

		System.out.println(kthSmallest(a[2], 1));
		System.out.println(kthSmallest(a[2], 2));
		System.out.println(kthSmallest(a[2], 3));
		System.out.println(kthSmallest(a[2], 4));
	}
}
