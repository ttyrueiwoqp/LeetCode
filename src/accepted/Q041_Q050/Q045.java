package accepted.Q041_Q050;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 10/26/2015.
 * <p/>
 * Given an array of non-negative integers, you are initially positioned
 * at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p/>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p/>
 * The minimum number of jumps to reach the last index is 2.
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Q045 {

	public int jump(int[] nums) {

		int n = nums.length;
		int[] mins = new int[n];
		mins[n - 1] = 0;
		List<Integer> localMins = new ArrayList<>();
		localMins.add(n - 1);

		for (int i = n - 2; i >= 0; i--) {
			mins[i] = mins[i + 1] + 1;
			for (int j = localMins.size() - 1; j >= 0; j--) {
				int localMinIdx = localMins.get(j);
				if (localMinIdx > i + nums[i]) {
					mins[i] = Math.min(mins[i], mins[i + nums[i]] + 1);
					break;
				} else if (mins[localMinIdx] + 1 < mins[i]) {
					mins[i] = mins[localMinIdx] + 1;
				}
			}

			if (mins[i] < mins[i + 1]) {
				localMins.add(i);
			}
		}

		return mins[0];
	}


	public int jump2(int[] A) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;

				if (curEnd >= A.length - 1) {
					break;
				}
			}
		}
		return jumps;
	}

	@Test
	public void test() {
		int[] a = {2, 3, 1, 1, 4};
		System.out.println(jump(a));
		int[] b = {4, 1, 1, 3, 1, 1, 1};
		System.out.println(jump(b));
		int[] c = {1, 2, 1, 1, 1};
		System.out.println(jump(c));

	}
}
