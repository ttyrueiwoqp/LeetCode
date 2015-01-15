package accepted.Q031_Q040;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class Q032 {

	public int longestValidParentheses1(String s) {

		if (s == null || s.isEmpty()) {
			return 0;
		}

		int[] st = new int[s.length()];
		int[] len = new int[s.length()];

		st[0] = 0;
		len[0] = 0;
		int cut = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st[i] = st[i - 1];
				len[i] = len[i - 1];
			} else {
				int sum = 1;
				for (int j = i - 1; j >= cut; j--) {
					if (s.charAt(j) == '(') {
						sum -= 1;
						if (sum < 0) {
							break;
						}
					} else {
						sum += 1;
					}
					if (sum == 0) {
						if (j == st[i - 1] + len[i - 1]) {
							// ____()
							st[i] = st[i - 1];
							len[i] = len[i - 1] + i - j + 1;
						} else if (j == st[i - 1] - 1) {
							// (___)
							st[i] = j;
							len[i] = len[i - 1] + 2;
						} else if (len[i - 1] == 0 || i - j + 1 >= len[i - 1]) {
							st[i] = j;
							len[i] = i - j + 1;
						}
					}
				}
				if (sum > 0) {
					cut = i;
				}
			}
		}

		int max = 0;
		for (int i = 1; i < s.length(); i++) {
			if (len[i] > max) {
				max = len[i];
			}
		}

		return max;
	}

	public int longestValidParentheses(String s) {

		int maxLen = 0;

		Deque<Integer> st = new ArrayDeque<Integer>();
		Deque<Integer> len = new ArrayDeque<Integer>();
		st.push(0);
		len.push(0);

		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '(') {
				int sum = 1, minInterval = s.length() - i;
				boolean hasValid = false;
				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(j) == '(') {
						sum++;
					} else {
						sum--;
						if (sum < minInterval) {
							minInterval = sum;
						}
					}
					if (sum == 0) {
						if (st.peek() + len.peek() == i) {
							int newLen = len.pop() + j + 1 - i;
							len.push(newLen);
						} else {
							st.push(i);
							len.push(j + 1 - i);
						}
						if (len.peek() > maxLen) {
							maxLen = len.peek();
						}

						hasValid = true;
						i = j + 1;
						break;
					}
				}
				if (!hasValid) {
					i += minInterval;
				}
			} else {
				i++;
			}
		}

		return maxLen;
	}

	@Test
	public void test() {
		assertEquals(4, longestValidParentheses("((()()(()((()"));
		assertEquals(6, longestValidParentheses(")()(())("));
		assertEquals(10, longestValidParentheses(")()(((())))("));
		assertEquals(4, longestValidParentheses(")()())"));
		assertEquals(6, longestValidParentheses("(()()))(()(())"));
		assertEquals(8, longestValidParentheses("(()()))(()(()))"));
		assertEquals(6, longestValidParentheses("()(()(())"));
		assertEquals(0, longestValidParentheses("(((((("));
	}

}
