package accepted.Q001_Q100.Q041_Q050;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class Q042 {

	public int trap1(int[] A) {

		if (A == null || A.length < 3) {
			return 0;
		}

		int i;
		int res = 0;
		int maxIdx = 0;
		int lastMaxIdx = 0;
		int sum = 0;

		for (i = 0; i < A.length; i++) {
			if (A[i] >= A[maxIdx]) {
				maxIdx = i;
			}
		}

		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(A[0]);

		i = 1;
		while (i <= maxIdx) {
			if (stack.peek() > A[i]) {
				stack.push(A[i]);
			} else {
				int curr = stack.peek();
				while (!stack.isEmpty() && stack.peek() <= A[i]) {
					curr = stack.poll();
					sum += curr;
				}
				if (stack.isEmpty()) {
					res += A[lastMaxIdx] * (i - lastMaxIdx) - sum;
					lastMaxIdx = i;
					sum = 0;
				}
				stack.push(A[i]);
			}
			i++;
		}

		int j = 0;
		int[] b = new int[A.length - lastMaxIdx];
		for (i = A.length - 1; i >= lastMaxIdx; i--) {
			b[j] = A[i];
			j++;
		}
		res += trap(b);

		return res;
	}

	public int trap(int[] A) {
		int left = 0;
		int right = A.length - 1;
		int res = 0;
		int maxleft = 0, maxright = 0;
		while (left <= right) {
			if (A[left] <= A[right]) {
				if (A[left] >= maxleft)
					maxleft = A[left];
				else
					res += maxleft - A[left];
				left++;
			} else {
				if (A[right] >= maxright)
					maxright = A[right];
				else
					res += maxright - A[right];
				right--;
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		assertEquals(6, trap(a));

		int[] aa = { 1, 2, 1, 2, 3, 1, 0, 1, 2, 0, 1, 0 };
		assertEquals(6, trap(aa));

		int[] b = { 2, 0, 2 };
		assertEquals(2, trap(b));

		int[] c = { 5, 4, 1, 2 };
		assertEquals(1, trap(c));

		int[] cc = { 2, 1, 4, 5 };
		assertEquals(1, trap(cc));

		int[] d = { 5, 2, 1, 2, 1, 5 };
		assertEquals(14, trap(d));

		int[] dd = { 5, 1, 2, 1, 2, 5 };
		assertEquals(14, trap(dd));
	}

}
