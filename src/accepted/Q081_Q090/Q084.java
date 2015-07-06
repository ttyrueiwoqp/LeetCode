package accepted.Q081_Q090;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by LU-PC on 7/6/2015.
 * <p>
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class Q084 {
	public int largestRectangleArea(int[] height) {
		int res = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i <= height.length; i++) {
			int h = i == height.length ? 0 : height[i];
			if (stack.isEmpty() || h >= height[stack.peek()]) {
				stack.push(i);
			} else {
				int p = stack.pop();
				res = Math.max(res, height[p] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
				i--;
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] a = {2, 1, 2};
		System.out.println(largestRectangleArea(a));
	}
}
