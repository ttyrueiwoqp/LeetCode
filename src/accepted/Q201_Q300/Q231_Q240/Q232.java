package accepted.Q201_Q300.Q231_Q240;

import java.util.Stack;

/**
 * Created by FJ on 10/10/2015.
 * <p/>
 * Implement the following operations of a queue using stacks.
 * <p/>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack --
 * which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively.
 * You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class Q232 {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> emptyStack = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x) {
		while (!stack.isEmpty()) {
			emptyStack.push(stack.pop());
		}
		stack.push(x);
		while (!emptyStack.isEmpty()) {
			stack.push(emptyStack.pop());
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		stack.pop();
	}

	// Get the front element.
	public int peek() {
		return stack.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}
}
