package accepted.Q021_Q030;

import util.ListNode;

/**
 * Created by LU-PC on 6/3/2015.
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Q021 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		curr.next = l1 != null ? l1 : (l2 != null ? l2 : null);

		return head.next;
	}
}
