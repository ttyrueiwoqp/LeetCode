package accepted.Q001_Q100.Q011_Q020;

import org.junit.Test;
import util.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class Q019 {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		List<ListNode> listNodes = new ArrayList<ListNode>();

		ListNode curr = new ListNode(0);
		curr.next = head;

		while (curr != null) {
			listNodes.add(curr);
			curr = curr.next;
		}

		int idx = listNodes.size() - n;
		if (idx + 1 > listNodes.size() - 1) {
			listNodes.get(idx - 1).next = null;
		} else {
			listNodes.get(idx - 1).next = listNodes.get(idx + 1);
		}

		return listNodes.get(0).next;
	}

	@Test
	public void test() throws Exception {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.next = b;
		assertEquals(null, removeNthFromEnd(a, 1));
	}

}
