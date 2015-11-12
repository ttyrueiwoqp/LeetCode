package accepted.Q301_Q310;

import org.junit.Test;

import java.util.*;

/**
 * Created by FJ on 11/12/2015.
 * <p/>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p/>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p/>
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class Q301 {


	public List<String> removeInvalidParentheses(String s) {

		List<String> res = new ArrayList<>();
		Deque<String> queue = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();
		queue.add(s);
		visited.add(s);

		boolean found = false;
		while (!queue.isEmpty()) {
			String curr = queue.poll();

			if (isValid(curr)) {
				res.add(curr);
				found = true;
			}

			if (found) {
				continue;
			}

			for (int i = 0; i < curr.length(); i++) {
				char c = curr.charAt(i);
				if (c == '(' || c == ')') {
					String temp = new StringBuilder(curr).deleteCharAt(i).toString();
					if (!visited.contains(temp)) {
						queue.add(temp);
						visited.add(temp);
					}
				}
			}
		}

		return res;
	}

	private boolean isValid(String s) {
		int i = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				i++;
			} else if (c == ')') {
				i--;
			}
			if (i < 0) {
				return false;
			}
		}
		return i == 0;
	}

	@Test
	public void test() {
		String s0 = "";
		String s1 = "()())()";
		String s2 = "(a)())()";
		String s3 = "(r(()()(";
		String s4 = "()())()()())()";
		System.out.println(removeInvalidParentheses(s0));
		System.out.println(removeInvalidParentheses(s1));
		System.out.println(removeInvalidParentheses(s2));
		System.out.println(removeInvalidParentheses(s3));
		System.out.println(removeInvalidParentheses(s4));
	}
}
