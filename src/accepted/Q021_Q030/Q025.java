package accepted.Q021_Q030;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.ListNode;

public class Q025 {

	public ListNode reverseKGroup(ListNode head, int k) {
		
		if (k < 2) {
			return head;
		}
		
		return reverseK(head, k);

	}
	
	public ListNode reverseK(ListNode head, int k) {
		
		List<ListNode> nodes = new ArrayList<ListNode>();
		int i = 0;
		ListNode curr = head;
		
		while (i < k) {
			if (curr == null) {
				return head;
			}
			nodes.add(curr);
			curr = curr.next;
			i++;
		}
		
		ListNode newHead = nodes.get(k - 1);
		for (int j = 1; j < k; j++) {
			nodes.get(j).next = nodes.get(j - 1);
		}
		nodes.get(0).next = reverseK(curr, k);
		
		return newHead;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
