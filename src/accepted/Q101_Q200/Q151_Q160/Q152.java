package accepted.Q101_Q200.Q151_Q160;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q152 {

	public int maxProduct(int[] A) {

		if (A.length == 1) {
			return A[0];
		}

		int max = Integer.MIN_VALUE;
		List<Integer> nums = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				nums.add(A[i]);
			} else {
				if (!nums.isEmpty()) {
					max = Math.max(findMax(nums), max);
					nums.clear();
				}
				max = Math.max(0, max);
			}
		}

		if (!nums.isEmpty()) {
			max = Math.max(findMax(nums), max);
		}

		return max;
	}

	private int findMax(List<Integer> nums) {

		if (nums.size() == 1) {
			return nums.get(0);
		}

		int prod = 1;
		List<Integer> negIdxs = new ArrayList<Integer>();
		List<Integer> prods = new ArrayList<Integer>();

		for (int i = 0; i < nums.size(); i++) {
			int val = nums.get(i);
			if (val < 0) {
				negIdxs.add(i);
			}
			prod *= val;
			prods.add(prod);
		}

		int numNegIdxs = negIdxs.size();
		if (numNegIdxs % 2 == 0) {
			return prod;
		}

		int first = negIdxs.get(0);
		int last = negIdxs.get(numNegIdxs - 1);

		if (last == 0) {
			return prod / prods.get(0);
		}

		int prodFirst = prods.get(first);
		int prodLast = prod / prods.get(last - 1);

		return prod / Math.max(prodFirst, prodLast);

	}
	
	public int maxProduct2(int[] A) {
	    if (A.length == 0) {
	        return 0;
	    }

	    int maxherepre = A[0];
	    int minherepre = A[0];
	    int maxsofar = A[0];
	    int maxhere, minhere;

	    for (int i = 1; i < A.length; i++) {
	        maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
	        minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
	        maxsofar = Math.max(maxhere, maxsofar);
	        maxherepre = maxhere;
	        minherepre = minhere;
	    }
	    return maxsofar;
	}

	@Test
	public void test() {
		int[] a = { -2, 5, 6, -2, -3 };
		assertEquals(180, maxProduct(a));

		int[] b = { -1, 1, 2, 1 };
		assertEquals(2, maxProduct(b));

		int[] c = { 0 };
		assertEquals(0, maxProduct(c));

		int[] d = { 0, -2, 0 };
		assertEquals(0, maxProduct(d));

		int[] e = { -4, -3, -2 };
		assertEquals(12, maxProduct(e));
	}

}
