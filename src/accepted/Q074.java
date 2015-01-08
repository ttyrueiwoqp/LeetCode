package accepted;

public class Q074 {

	public boolean searchMatrix(int[][] matrix, int target) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		int start = 0;
		int end = rows * cols - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int curr = matrix[mid / cols][mid % cols];
			if (curr == target) {
				return true;
			} else if (curr > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return false;
	}

}
