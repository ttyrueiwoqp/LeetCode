package accepted.Q101_Q200.Q151_Q160;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q150 {

	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<Integer>();

		int sum = 0;
		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i].equals("+")) {
				int a = stack.pop();
				int b = stack.pop();
				sum = b + a;
				stack.push(sum);
			} else if (tokens[i].equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				sum = b - a;
				stack.push(sum);
			} else if (tokens[i].equals("*")) {
				int a = stack.pop();
				int b = stack.pop();
				sum = b * a;
				stack.push(sum);
			} else if (tokens[i].equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				sum = b / a;
				stack.push(sum);
			} else {
				int a = Integer.parseInt(tokens[i]);
				sum = a;
				stack.push(a);
			}

		}
		return sum;
	}

}
