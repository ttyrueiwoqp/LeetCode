package accepted.Q091_Q100;

import org.junit.Test;
import util.ListNode;

/**
 * Created by LU-PC on 7/2/2015.
 * <p>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ? m ? n ? length of list.
 */
public class Q092 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = head.next;
		int idx = 1;
		while (next != null && idx < m) {
			prev = curr;
			curr = next;
			next = next.next;
			idx++;
		}

		ListNode st = prev;
		ListNode end = curr;

		while (next != null && idx < n) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
			idx++;
		}
		curr.next = prev;

		if (st != null) {
			st.next = curr;
		} else {
			head = curr;
		}
		end.next = next;

		return head;
	}

	@Test
	public void test() {
		ListNode a = new ListNode(1);
//		ListNode b = new ListNode(2);
//		ListNode c = new ListNode(3);
//		ListNode d = new ListNode(4);
//		ListNode e = new ListNode(5);
//		a.next = b;
//		b.next = c;
//		c.next = d;
//		d.next = e;
		System.out.println(reverseBetween(a, 1, 1));
	}
}
