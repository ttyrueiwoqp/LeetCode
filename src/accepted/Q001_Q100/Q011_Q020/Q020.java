package accepted.Q001_Q100.Q011_Q020;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}"
 * are all valid but "(]" and "([)]" are not.
 */
public class Q020 {

	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
				case '(':
				case '{':
				case '[':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(')
						return false;
					break;
				case '}':
					if (stack.isEmpty() || stack.pop() != '{')
						return false;
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[')
						return false;
					break;
				default:
					break;
			}
		}
		return stack.isEmpty();
	}

}
