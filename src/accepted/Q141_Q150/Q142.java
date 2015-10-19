package accepted.Q141_Q150;

import org.junit.Test;
import util.ListNode;

/**
 * Created by FJ on 10/18/2015.
 * <p>
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Q142 {

	public ListNode detectCycle(ListNode head) {

		ListNode cycleNode = findCycleNode(head);
		if (cycleNode == null) {
			return null;
		}
		ListNode currA = head;
		ListNode currB = cycleNode.next;

		while (currA != currB) {
			currA = currA.next;
			currB = currB == cycleNode ? head : currB.next;
		}

		return currA;
	}

	private ListNode findCycleNode(ListNode head) {
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

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		n1.next = n1;

		System.out.println(detectCycle(n1).val);

		int[] a = {-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5};
		ListNode[] b = new ListNode[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = new ListNode(a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1) {
				b[i].next = b[i + 1];
			} else {
				b[i].next = b[24];
			}
		}
		System.out.println(b[24].val);
		System.out.println(detectCycle(b[0]).val);
	}
}
