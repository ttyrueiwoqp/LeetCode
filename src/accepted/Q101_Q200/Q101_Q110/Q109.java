package accepted.Q101_Q200.Q101_Q110;

import util.ListNode;
import util.TreeNode;

/**
 * Created by LU-PC on 7/3/2015.
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class Q109 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (prev != null) {
			prev.next = null;
		}

		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}

}
