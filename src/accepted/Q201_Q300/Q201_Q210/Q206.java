package accepted.Q201_Q300.Q201_Q210;

import util.ListNode;

/**
 * Created by LU-PC on 6/2/2015.
 *
 * Reverse a singly linked list.
 */
public class Q206 {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = head.next;
		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		return curr;
	}
}
