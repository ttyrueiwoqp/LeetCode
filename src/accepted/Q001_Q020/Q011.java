package accepted.Q001_Q020;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q011 {

	public int maxArea(int[] height) {

		int j = height.length - 1, i = 0, max = 0;

		while (i < j) {
			max = Math.max(max, ((j - i) * (Math.min(height[i], height[j]))));

			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return max;
	}

	@Test
	public void test() {
		int[] a = { 3, 5, 6, 4, 9, 1 };
		assertEquals(15, maxArea(a));

		int[] b = { 1, 2, 3, 4, 3, 2 };
		assertEquals(8, maxArea(b));

		int[] c = { 1, 2, 4, 3 };
		assertEquals(4, maxArea(c));

	}

}
