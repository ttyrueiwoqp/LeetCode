package qns;

import util.ListNode;

/**
 * Created by FJ on 10/18/2015.
 * <p/>
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p/>
 * Note: Do not modify the linked list.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Q142 {

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast || slow == fast.next) {
				return slow;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return null;
	}
}
