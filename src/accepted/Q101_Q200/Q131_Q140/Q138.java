package accepted.Q101_Q200.Q131_Q140;

import org.junit.Test;
import util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LU-PC on 6/10/2015.
 * <p>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
public class Q138 {
	public RandomListNode copyRandomList(RandomListNode head) {

		Map<RandomListNode, RandomListNode> m = new HashMap<>();

		RandomListNode newHead = new RandomListNode(0);
		RandomListNode prev = newHead;
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode t = new RandomListNode(curr.label);
			m.put(curr, t);
			prev.next = t;
			prev = t;
			curr = curr.next;
		}

		curr = head;
		prev = newHead.next;
		while (curr != null) {
			prev.random = m.get(curr.random);
			curr = curr.next;
			prev = prev.next;
		}

		return newHead.next;
	}

	@Test
	public void test() {
		RandomListNode[] a = new RandomListNode[4];

		for (int i = 0; i < 4; i++) {
			a[i] = new RandomListNode(i);
		}

		for (int i = 0; i < 3; i++) {
			a[i].next = a[i + 1];
			a[i].random = a[3 - i];
		}

		for (int i = 0; i < 4; i++) {
			System.out.println(a[i]);
		}
		System.out.println();

		RandomListNode res = copyRandomList(a[0]);
		while (res != null) {
			System.out.println(res);
			res = res.next;
		}
	}
}
