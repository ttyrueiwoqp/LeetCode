package accepted.Q051_Q060;

public class Q053 {

	public int maxSubArray(int[] A) {

		int result = A[0];
		int[] max = new int[A.length];

		max[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			max[i] = Math.max(max[i - 1], 0) + A[i];
			if (max[i] > result) {
				result = max[i];
			}
		}
		return result;
	}

}
