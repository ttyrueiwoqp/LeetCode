package accepted.Q041_Q050;

public class Q041 {
	
	public int firstMissingPositive(int[] A) {

		int[] B = new int[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] <= A.length) {
				B[A[i]] = 1;
			}
		}
		for (int i = 1; i < B.length; i++) {
			if (B[i] != 1) {
				return i;
			}
		}
		return B.length;
	}
	
}
