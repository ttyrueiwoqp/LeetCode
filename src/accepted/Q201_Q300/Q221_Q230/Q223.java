package accepted.Q201_Q300.Q221_Q230;

import org.junit.Test;

/**
 * Created by LU-PC on 6/15/2015.
 * <p>
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class Q223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int first = (C - A) * (D - B);
		int second = (G - E) * (H - F);

		int w = Math.min(C, G) - Math.max(A, E);
		w = w > 0 ? w : 0;

		int h = Math.min(D, H) - Math.max(B, F);
		h = h > 0 ? h : 0;

		return first + second - w * h;
	}

	@Test
	public void test() {
		System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}

}
