package accepted.Q201_Q300.Q271_Q280;

import org.junit.Test;

/**
 * Created by LU-PC on 10/8/2015.
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 * Could you optimize your algorithm?
 */
public class Q275 {

	public int hIndex(int[] citations) {
		if (citations.length == 0) {
			return 0;
		}
		return citations.length - binarySearch(citations, 0, citations.length - 1);
	}

	private int binarySearch(int[] citations, int st, int end) {
		if (st == end) {
			return isH(citations, st) ? st : citations.length;
		}
		int mid = st + (end - st) / 2;

		if (isH(citations, mid)) {
			return binarySearch(citations, st, mid);
		} else {
			return binarySearch(citations, mid + 1, end);
		}
	}

	private boolean isH(int[] citations, int i) {
		return citations[i] >= citations.length - i;
	}

	@Test
	public void test() {
		int[] citations = {0, 1, 3, 5, 6};
		System.out.println(hIndex(citations));
	}
}
