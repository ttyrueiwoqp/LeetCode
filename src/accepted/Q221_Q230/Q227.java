package accepted.Q221_Q230;

import org.junit.Test;

import java.util.*;

/**
 * Created by LU-PC on 7/2/2015.
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 */
public class Q227 {
	public int calculate(String s) {
		Map<String, Integer> opsMap = createOpsMap();
		String postfix = getPostfixFromInfix(s, opsMap);
		return computePostfix(postfix, opsMap);
	}

	private Map<String, Integer> createOpsMap() {
		Map<String, Integer> m = new HashMap<>();
		m.put("+", 4);
		m.put("-", 4);
		m.put("*", 3);
		m.put("/", 3);
		m.put("(", Integer.MAX_VALUE);
		m.put(")", Integer.MAX_VALUE);
		return m;
	}

	private String getPostfixFromInfix(String infix, Map<String, Integer> opsMap) {

		StringBuilder sb = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();

		char[] cs = infix.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];

			if (c == '(') {
				stack.push(c);

			} else if (c == ')') {
				while (stack.peek() != '(') {
					sb.append(stack.pop()).append(" ");
				}
				stack.pop();

			} else if (c == '+' || c == '*' || c == '/') {
				// operator
				while (!stack.isEmpty()
						&& opsMap.get(String.valueOf(c)) >= opsMap.get(String.valueOf(stack.peek()))) {
					sb.append(stack.pop()).append(" ");
				}
				stack.push(c);


			} else if (c == '-') {
				while (!stack.isEmpty()
						&& opsMap.get(String.valueOf(c)) >= opsMap.get(String.valueOf(stack.peek()))) {
					sb.append(stack.pop()).append(" ");
				}
				sb.append('-');
				stack.push('+');

			} else if (Character.isDigit(c)) {
				// number
				do {
					sb.append(cs[i]);
					i++;
				} while (i < cs.length && Character.isDigit(cs[i]));
				sb.append(" ");
				i--;
			}
		}

		while (!stack.isEmpty()) {
			Character c = stack.pop();
			sb.append(c).append(" ");
		}

		return sb.toString();
	}

	private int computePostfix(String postfix, Map<String, Integer> ops) {

		Deque<Integer> stack = new ArrayDeque<>();

		String[] tokens = postfix.split("\\s");
		for (String token : tokens) {
			int first;
			int second;
			if (ops.containsKey(token)) {
				switch (token) {

					case "+":
						stack.push(stack.pop() + stack.pop());
						break;

					case "-":
						first = stack.pop();
						second = stack.pop();
						stack.push(second - first);
						break;

					case "*":
						stack.push(stack.pop() * stack.pop());
						break;

					case "/":
						first = stack.pop();
						second = stack.pop();
						stack.push(second / first);
						break;

					default:
						break;
				}
			} else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}

	@Test
	public void test() {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 23-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(calculate("0-2147483648"));
		System.out.println(calculate("3+2*2"));
		System.out.println(calculate(" 3/2 "));
		System.out.println(calculate(" 3+5 / 2 "));
	}
}
