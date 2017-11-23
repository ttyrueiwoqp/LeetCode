package accepted.Q001_Q100.Q081_Q090;

import org.junit.Test;
import util.ListNode;

/**
 * Created by LU-PC on 6/4/2015.
 * <p>
 * Given a linked list and a value x, partition it such that
 * all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes
 * in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class Q086 {
	public ListNode partition(ListNode head, int x) {

		ListNode prevHead = new ListNode(0);
		ListNode prev = prevHead;
		prev.next = head;
		ListNode curr = head;
		ListNode head2 = new ListNode(0);
		ListNode curr2 = head2;

		while (curr != null) {
			if (curr.val >= x) {
				curr2.next = curr;
				prev.next = curr.next;
				curr = curr.next;
				curr2 = curr2.next;
				curr2.next = null;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}

		prev.next = head2.next;
		return prevHead.next;
	}

	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l2.next = l1;
		System.out.println(partition(l2, 2));
	}
}
