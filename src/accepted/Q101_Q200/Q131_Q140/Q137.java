package accepted.Q101_Q200.Q131_Q140;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Q137 {

	public int singleNumber(int[] A) {

		if (A.length == 1) {
			return A[0];
		}

		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {

			if (s1.contains(A[i])) {
				if (s2.contains(A[i])) {
					s1.remove(A[i]);
				} else {
					s2.add(A[i]);
				}
			} else {
				s1.add(A[i]);
			}
		}

		return (int) s1.toArray()[0];
	}

	public int singleNumber2(int[] A) {
		int ones = 0, twos = 0;
		for (int i = 0; i < A.length; i++) {
			System.out.print("A " + ones + " ");
			ones = (ones ^ A[i]) & ~twos;
			System.out.print("NA " + ones + " ");
			System.out.print("B " + twos + " ");
			twos = (twos ^ A[i]) & ~ones;
			System.out.print("NB " + twos + " ");
			System.out.println();
		}
		return ones;
	}

	@Test
	public void test() {

		int[] a = { 1, 1, 1, 1};
		System.out.println(singleNumber2(a));

	}

}
