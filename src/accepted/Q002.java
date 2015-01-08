package accepted;

import util.ListNode;

public class Q002 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int m = 0;
		ListNode h1 = l1;
		ListNode h2 = l2;
		ListNode result = new ListNode(0);
		ListNode curr = result;

		while (h1 != null && h2 != null) {
			int sum = h1.val + h2.val + m;
			if (sum >= 10) {
				m = 1;
				sum -= 10;
			} else {
				m = 0;
			}
			curr.next = new ListNode(sum);
			curr = curr.next;
			h1 = h1.next;
			h2 = h2.next;
		}

		if (h1 != null && h2 == null) {
			process(curr, h1, m);
		} else if (h1 == null && h2 != null) {
			process(curr, h2, m);
		} else {
			process(curr, null, m);
		}
		return result.next;
	}

	private void process(ListNode curr, ListNode h, int m) {
		if (m == 0) {
			curr.next = h;
		} else if (m == 1) {
			if (h == null) {
				curr.next = new ListNode(1);
			} else {
				ListNode t = h;
				while (t != null) {
					if (t.val + m >= 10) {
						t.val = t.val + m - 10;
						if (t.next == null) {
							t.next = new ListNode(0);
						}
						t = t.next;
					} else {
						t.val = t.val + m;
						break;
					}
				}
				curr.next = h;
			}
		}
	}

}
