package accepted.Q301_Q400.Q381_Q390;

/**
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 * <p>
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 * <p>
 * Example:
 * <p>
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom() should return either 1, 2, or 3 randomly.
 * Each element should have equal probability of returning.
 * solution.getRandom();
 */

import util.ListNode;

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Q382 {

    ListNode head;
    Random rand;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null,
     *             so it contains at least one node.
     */
    public Q382(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        if (head == null) {
            return 0;
        }

        int res = head.val;
        ListNode curr = head.next;

        int i = 2;
        while (curr != null) {
            int j = rand.nextInt(i);
            if (j == 0) {
                res = curr.val;
            }

            i++;
            curr = curr.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */