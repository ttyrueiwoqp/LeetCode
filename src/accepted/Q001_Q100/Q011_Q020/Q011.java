package accepted.Q001_Q100.Q011_Q020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container.
 */
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
		int[] a = {3, 5, 6, 4, 9, 1};
		assertEquals(15, maxArea(a));

		int[] b = {1, 2, 3, 4, 3, 2};
		assertEquals(8, maxArea(b));

		int[] c = {1, 2, 4, 3};
		assertEquals(4, maxArea(c));

	}

}
