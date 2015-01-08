package accepted;

import java.util.ArrayList;
import java.util.List;

import util.ListNode;

public class Q061 {

	public ListNode rotateRight(ListNode head, int n) {

		if (head == null || n == 0) {
			return head;
		}

		List<ListNode> nodes = new ArrayList<ListNode>();
		ListNode curr = head;
		while (curr != null) {
			nodes.add(curr);
			curr = curr.next;
		}

		n = n % nodes.size();
		if (n == 0) {
			return head;
		}

		nodes.get(nodes.size() - 1).next = nodes.get(0);
		nodes.get(nodes.size() - 1 - n).next = null;

		return nodes.get(nodes.size() - n);
	}
}
