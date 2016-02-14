package accepted.Q321_Q330;

import org.junit.Test;

/**
 * Created by FJ on 2/14/2016.
 * <p/>
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two.
 * The relative order of the digits from the same array must be preserved.
 * Return an array of the k digits. You should try to optimize your time and space complexity.
 * <p/>
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 * <p/>
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 * <p/>
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 */
public class Q321 {

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {

		if (k <= 0 || k > nums1.length + nums2.length) {
			return null;
		}

		int[] res = new int[k];
		int st = Math.max(0, k - nums2.length);
		int end = Math.min(nums1.length, k);

		for (int i = st; i <= end; i++) {
			int[] t1 = maxNum(nums1, i);
			int[] t2 = maxNum(nums2, k - i);
			int[] t = new int[k];
			int p1 = 0, p2 = 0, p = 0;

			while(p1 < t1.length || p2 < t2.length) {
				t[p++] = isGreater(t1, p1, t2, p2) ? t1[p1++] : t2[p2++];
			}

			if (isGreater(t, 0, res, 0)) {
				res = t;
			}
		}

		return res;
	}

	public boolean isGreater(int[] num1, int i, int[] num2, int j) {
		while (i < num1.length && j < num2.length) {
			if (num1[i] == num2[j]) {
				i++;
				j++;
			} else {
				return num1[i] > num2[j];
			}
		}
		return j == num2.length;

	}

	public int[] maxNum(int[] num, int k) {
		int[] res = new int[k];

		for (int i = 0, j = 0; i < num.length; i++) {
			while (j > 0 && num.length - i + j > k && num[i] > res[j - 1]) {
				j--;
			}
			if (j < k) {
				res[j] = num[i];
				j++;
			}
		}

		return res;
	}

	@Test
	public void test() {
//		int[] a1 = {3, 4, 6, 5};
//		int[] a2 = {9, 1, 2, 5, 8, 3};
//
//		int[] a = maxNumber(a1, a2, 5);
//		print(a);

		int[] b1 = {6,7};
		int[] b2 = {6,0,4};

		int[] b = maxNumber(b1, b2, 5);
		print(b);
	}

	private void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}


}
