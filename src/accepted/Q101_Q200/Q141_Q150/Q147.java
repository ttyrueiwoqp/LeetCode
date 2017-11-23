package accepted.Q101_Q200.Q141_Q150;

import org.junit.Test;
import util.ListNode;

/**
 * Created by FJ on 3/19/2016.
 * <p/>
 * Sort a linked list using insertion sort.
 */
public class Q147 {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode res = new ListNode(0);
		ListNode curr = res;

		ListNode pHead = head;
		ListNode p = pHead;

		while (p != null) {
			if (curr.val > p.val) {
				curr = res;
			}
			while (curr.next != null && p.val > curr.next.val) {
				curr = curr.next;
			}
			pHead = p.next;
			p.next = curr.next;
			curr.next = p;

			p = pHead;
		}

		return res.next;
	}

	@Test
	public void test() {
		ListNode[] a = new ListNode[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ListNode(a.length - i);
		}
		for (int i = 0; i < a.length - 1; i++) {
			a[i].next = a[i + 1];
		}

		System.out.println(insertionSortList(a[0]));
	}
}
