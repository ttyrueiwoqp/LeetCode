package accepted.Q221_Q230;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by FJ on 10/18/2015.
 * <p/>
 * Implement the following operations of a stack using queues.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class Q225 {

	private Deque<Integer> queue = new ArrayDeque<>();
	private Deque<Integer> emptyQueue = new ArrayDeque<>();

	// Push element x onto stack.
	public void push(int x) {
		while (!queue.isEmpty()) {
			emptyQueue.addLast(queue.pop());
		}
		queue.addLast(x);
		while (!emptyQueue.isEmpty()) {
			queue.addLast(emptyQueue.pop());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue.pop();
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}

	@Test
	public void test() {
		Q225 q = new Q225();
		q.push(1);
		q.push(2);
		System.out.println(q.top());
	}

}
