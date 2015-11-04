package accepted.Q241_Q250;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 11/3/2015.
 * <p/>
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * <p/>
 * <p/>
 * Example 1
 * Input: "2-1-1".
 * <p/>
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * <p/>
 * <p/>
 * Example 2
 * Input: "2*3-4*5"
 * <p/>
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class Q241 {

	public List<Integer> diffWaysToCompute(String input) {

		List<Integer> nums = new ArrayList<>();
		List<Character> ops = new ArrayList<>();

		parseInput(input, nums, ops);

		return compute(nums, 0, nums.size() - 1, ops);
	}

	private List<Integer> compute(List<Integer> nums, int st, int end, List<Character> ops) {

		List<Integer> res = new ArrayList<>();

		if (st == end) {
			res.add(nums.get(st));
			return res;
		}

		for (int i = st; i < end; i++) {
			List<Integer> left = compute(nums, st, i, ops);
			List<Integer> right = compute(nums, i+1, end, ops);
			calc(res, left, right, ops.get(i));
		}

		return res;
	}

	private List<Integer> calc(List<Integer> res, List<Integer> front, List<Integer> back, char op) {
		for (int f : front) {
			for (int b : back) {
				res.add(calc(f, b, op));
			}
		}
		return res;
	}

	private int calc(int a, int b, char op) {
		switch (op) {
			case '*':
				return a * b;
			case '+':
				return a + b;
			case '-':
				return a - b;
			default:
				return 0;
		}
	}

	private void parseInput(String input, List<Integer> nums, List<Character> ops) {

		int i = 0, lastOpIdx = -1;
		char[] cs = input.toCharArray();

		while (i < cs.length) {
			if (!Character.isDigit(cs[i])) {
				ops.add(cs[i]);
				nums.add(Integer.parseInt(input.substring(lastOpIdx + 1, i)));
				lastOpIdx = i;
			}
			i++;
		}
		nums.add(Integer.parseInt(input.substring(lastOpIdx + 1, i)));
	}

	@Test
	public void test() {
		String s = "2*3-4*5";
		System.out.println(diffWaysToCompute(s));
	}
}
