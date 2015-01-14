package accepted.Q021_Q030;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.ListNode;

public class Q023 {

	public ListNode mergeKLists(List<ListNode> lists) {

		int size = lists.size();
		if (size == 0) {
			return null;
		} else if (size == 1) {
			return lists.get(0);
		} else {
			return merge2Lists(mergeKLists(lists.subList(0, size / 2)),
					mergeKLists(lists.subList(size / 2, size)));
		}
	}

	public ListNode merge2Lists(ListNode list1, ListNode list2) {

		ListNode res = new ListNode(0);
		ListNode m = list1, n = list2, curr = res;

		while (m != null && n != null) {
			if (m.val < n.val) {
				curr.next = m;
				m = m.next;
			} else {
				curr.next = n;
				n = n.next;
			}
			curr = curr.next;
		}

		if (m == null) {
			curr.next = n;
		} else {
			curr.next = m;
		}

		return res.next;
	}

	@Test
	public void test() {
		List<ListNode> list = new ArrayList<ListNode>();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(0);
		list.add(a);
		list.add(b);
		System.out.println(mergeKLists(list));
		System.out.println(merge2Lists(list.get(0), list.get(1)));
	}

}
