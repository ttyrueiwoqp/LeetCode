package accepted.Q001_Q020;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.ListNode;

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
