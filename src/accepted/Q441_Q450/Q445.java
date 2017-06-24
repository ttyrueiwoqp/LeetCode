package accepted.Q441_Q450;

import util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class Q445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();

        int len1 = fillStack(stack1, l1);
        int len2 = fillStack(stack2, l2);

        if (len1 > len2) {
            return helper(stack1, stack2);
        } else {
            return helper(stack2, stack1);
        }
    }

    private ListNode helper(Deque<ListNode> stack1, Deque<ListNode> stack2) {
        Deque<ListNode> stack = new ArrayDeque<>();

        int carry = 0;
        while (!stack1.isEmpty()) {
            ListNode curr1 = stack1.pop();
            int sum = curr1.val + carry;

            if (!stack2.isEmpty()) {
                ListNode curr2 = stack2.pop();
                sum += curr2.val;
            }
            carry = sum / 10;
            stack.push(new ListNode(sum % 10));
        }

        if (carry == 1) {
            stack.push(new ListNode(1));
        }

        ListNode res = new ListNode(0);
        ListNode curr = res;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }

        return res.next;
    }

    private int fillStack(Deque<ListNode> stack, ListNode l) {
        ListNode curr = l;
        int count = 0;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
            count++;
        }
        return count;
    }
}
