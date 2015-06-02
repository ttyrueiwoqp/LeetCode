package accepted.Q151_Q160;

import org.junit.Test;
import util.ListNode;

/**
 * Created by LU-PC on 6/2/2015.
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 ? a2
 * ?
 * c1 ? c2 ? c3
 * ?
 * B:     b1 ? b2 ? b3
 * begin to intersect at node c1.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Q160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode currA = headA, currB = headB;
		while (currA != currB) {
			currA = currA == null ? headB : currA.next;
			currB = currB == null ? headA : currB.next;
		}
		return currA;
	}

	@Test
	public void test() {

	}
}
