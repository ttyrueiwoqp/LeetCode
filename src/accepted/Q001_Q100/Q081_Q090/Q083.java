package accepted.Q001_Q100.Q081_Q090;

import org.junit.Test;
import util.ListNode;

import static org.junit.Assert.fail;

public class Q083 {

	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode curr = head;
		
		while (curr != null) {
			ListNode rep = curr.next;
			while (rep != null && rep.val == curr.val) {
				rep = rep.next;
			}
			curr.next = rep;
			curr = curr.next;
		}
		
		return head;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
