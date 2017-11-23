package accepted.Q201_Q300.Q271_Q280;

import org.junit.Test;

/**
 * Created by LU-PC on 10/8/2015.
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class Q278 {

	public int firstBadVersion(int n) {
		if (!isBadVersion(n)) {
			return 0;
		}
		return binarySearch(1, n);
	}

	private int binarySearch(int i, int n) {
		int mid = i + (n - i) / 2;
		if (mid == i) {
			return isBadVersion(mid) ? mid : mid + 1;
		}

		if (!isBadVersion(mid) && isBadVersion(mid + 1)) {
			return mid + 1;
		} else if (isBadVersion(mid)) {
			return binarySearch(i, mid);
		} else {
			return binarySearch(mid + 1, n);
		}
	}

	private boolean isBadVersion(int version) {
		return version >= 1702766719;
	}

	@Test
	public void test() {
		System.out.println(firstBadVersion(2126753390));
	}

}
