package accepted.Q271_Q280;

import java.util.Arrays;

/**
 * Created by LU-PC on 10/8/2015.
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 * Could you optimize your algorithm?
 */
public class Q275 {

	public int hIndex(int[] citations) {

		int result = 0;
		for (int i = citations.length - 1;  i >= 0; i--) {
			int h = citations.length - i;
			if (citations[i] >= h) {
				if (i == 0) {
					return h;
				}
				result = h;
			} else {
				break;
			}
		}
		return result;
	}
}
