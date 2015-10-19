package accepted.Q141_Q150;

import org.junit.Test;
import util.ListNode;

/**
 * Created by FJ on 10/18/2015.
 * <p/>
 * Given a linked list, determine if it has a cycle in it.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Q141 {

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast || slow == fast.next) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return false;
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		n1.next = n1;

		System.out.println(hasCycle(n1));
	}
}
