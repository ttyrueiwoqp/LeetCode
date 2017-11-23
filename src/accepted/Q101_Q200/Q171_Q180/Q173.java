package accepted.Q101_Q200.Q171_Q180;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by LU-PC on 7/3/2015.
 * <p>
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * <p>
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class Q173 {


	public class BSTIterator {

		private TreeNode root;
		private Deque<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			this.root = root;
			this.stack = new ArrayDeque<>();
			TreeNode curr = root;
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
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

		}
	}
}

