package qns;

import java.util.*;

/**
 * Created by LU-PC on 6/2/2015.
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class Q155 {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int x = stack.pop();
			if (x == minStack.peek()) {
				minStack.pop();
			}
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}
