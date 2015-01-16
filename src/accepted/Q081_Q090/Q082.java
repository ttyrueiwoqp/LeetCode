package accepted.Q081_Q090;

import org.junit.Test;

import util.ListNode;

public class Q082 {

	public ListNode deleteDuplicates(ListNode head) {

		ListNode curr = head;
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode prev = newHead;

		while (curr != null) {
			ListNode rep = curr.next;
			boolean hasRep = false;
			while (rep != null && rep.val == curr.val) {
				rep = rep.next;
				hasRep = true;
			}

			if (hasRep) {
				prev.next = rep;
			} else {
				prev = curr;
			}
			curr = rep;
		}

		return newHead.next;
	}

	@Test
	public void test() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		a.next = b;
		b.next = c;

		System.out.println(deleteDuplicates(a));
	}

}
