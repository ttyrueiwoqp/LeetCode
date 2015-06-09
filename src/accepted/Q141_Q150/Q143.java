package accepted.Q141_Q150;

import org.junit.Test;
import util.ListNode;

import java.util.List;

/**
 * Created by LU-PC on 6/8/2015.
 * <p>
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class Q143 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		int size = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			size++;
		}

		int idx = 0;
		p = head;
		while (idx < size / 2) {
			p = p.next;
			idx++;
		}
		ListNode q = p.next;
		p.next = null;

		q = reverse(q);
		p = head;
		while (q != null) {
			ListNode qNext = q.next;
			q.next = p.next;
			p.next = q;
			p = q.next;
			q = qNext;
		}
	}

	private ListNode reverse(ListNode head) {
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


	public void reorderList2(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		reOrder(head, head);
	}

	private ListNode reOrder(ListNode head, ListNode tail) {
		if (tail.next == null) {
			return head;
		}
		ListNode curr = reOrder(head, tail.next);
		if (curr == null || curr.next == null) {
			return null;
		}

		ListNode temp = tail.next;
		tail.next = null;
		temp.next = curr.next;
		curr.next = temp;
		return temp.next;
	}


	@Test
	public void test() {

		int k = 5;
		ListNode[] ns = new ListNode[k + 1];
		for (int i = 0; i <= k; i++) {
			ns[i] = new ListNode(i);
		}
		for (int i = 0; i < k; i++) {
			ns[i].next = ns[i + 1];
		}

//		System.out.println(reverse(ns[0]));

		reorderList(ns[0]);
		System.out.println(ns[0]);
	}
}
