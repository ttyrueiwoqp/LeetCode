package accepted.Q021_Q030;

import java.util.ArrayList;
import java.util.List;

import util.ListNode;

public class Q024 {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		List<ListNode> list = new ArrayList<ListNode>();
		ListNode curr = head;
		while (curr != null) {
			list.add(curr);
			curr = curr.next;
		}
		for (int i = 0; i < list.size(); i++) {
			curr = list.get(i);
			if (i % 2 == 0) {
				if (i + 3 < list.size()) {
					curr.next = list.get(i + 3);
				} else if (i + 2 < list.size()) {
					curr.next = list.get(i + 2);
				} else {
					curr.next = null;
				}
			} else {
				curr.next = list.get(i - 1);
			}
		}

		return list.get(1);
	}

}
