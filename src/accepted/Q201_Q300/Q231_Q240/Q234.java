package accepted.Q201_Q300.Q231_Q240;

import org.junit.Test;
import util.ListNode;

/**
 * Created by FJ on 10/17/2015.
 * <p/>
 * Given a singly linked list, determine if it is a palindrome.
 * <p/>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Q234 {

	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null) {
			return true;
		}

		ListNode curr = head;
		int cnt = 0;
		while (curr != null) {
			curr = curr.next;
			cnt++;
		}

		ListNode prev;
		curr = head;
		ListNode next = curr.next;

		int mid = cnt / 2 - 1;
		while (mid > 0) {
			prev = curr;
			curr = next;
			next = next.next;
			curr.next = prev;
			mid--;
		}
		if (cnt % 2 == 1) {
			next = next.next;
		}

		while (next != null) {
			if (curr.val != next.val) {
				return false;
			}
			curr = curr.next;
			next = next.next;
		}

		return true;
	}


	@Test
	public void test() {

		ListNode a1 = new ListNode(7);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(2);
		ListNode a5 = new ListNode(1);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;

		System.out.println(isPalindrome(a1));
	}
}
