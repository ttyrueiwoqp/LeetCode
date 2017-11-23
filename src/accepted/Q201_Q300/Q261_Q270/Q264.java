package accepted.Q201_Q300.Q261_Q270;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 10/8/2015.
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 */
public class Q264 {

	public int nthUglyNumber(int n) {

		if (n < 1) {
			return 0;
		}

		int idx2 = 0, idx3 = 0, idx5 = 0;
		List<Integer> list = new ArrayList<>();
		list.add(1);

		int count = 1;
		while (count < n) {
			count++;
			int p2 = list.get(idx2) * 2;
			int p3 = list.get(idx3) * 3;
			int p5 = list.get(idx5) * 5;

			int next = Math.min(p2, Math.min(p3, p5));
			list.add(next);
			if (p2 == next) {
				idx2++;
			}
			if (p3 == next) {
				idx3++;
			}
			if (p5 == next) {
				idx5++;
			}

		}
		return list.get(list.size() - 1);
	}

	@Test
	public void test() {
		System.out.println(nthUglyNumber(6));
		System.out.println(nthUglyNumber(8));
		System.out.println(nthUglyNumber(10));
		System.out.println(nthUglyNumber(1));
		System.out.println(nthUglyNumber(1352));
	}
}
