package accepted.Q321_Q330;

import org.junit.Test;
import util.ListNode;

/**
 * Created by FJ on 1/24/2016.
 * <p/>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p/>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p/>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p/>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class Q328 {

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode odd = head;
		ListNode even = head.next;
		ListNode mid = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;

			even.next = odd.next;
			even = even.next;
		}
		odd.next = mid;

		return head;
	}

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		System.out.println(oddEvenList(head));
	}
}
