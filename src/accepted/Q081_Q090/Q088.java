package accepted.Q081_Q090;

/**
 * Created by LU-PC on 6/2/2015.
 * <p>
 * Given two sorted integer arrays nums1 and nums2,
 * merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space
 * (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2
 * are m and n respectively.
 */
public class Q088 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		while (n > 0) {
			nums1[m + n - 1] = (m == 0 || nums1[m - 1] < nums2[n - 1]) ? nums2[--n] : nums1[--m];
		}
	}
}
