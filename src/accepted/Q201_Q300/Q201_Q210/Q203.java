package accepted.Q201_Q300.Q201_Q210;

import util.ListNode;

/**
 * Created by LU-PC on 6/2/2015.
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class Q203 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode res = new ListNode(0);
		ListNode prev = res;
		prev.next = head;
		ListNode curr = head;
		while (curr != null) {
			if (curr.val == val) {
				prev.next = curr.next;
			} else {
				prev = curr;
			}
			curr = curr.next;
		}
		return res.next;
	}
}
