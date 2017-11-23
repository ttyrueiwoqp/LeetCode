package accepted.Q001_Q100.Q031_Q040;

public class Q031 {

	public void nextPermutation(int[] num) {
		int size = num.length;
		if (size < 2) {
			return;
		}
		int stop = 0;
		for (int i = size - 1; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				stop = i;
				break;
			}
		}
		if (stop > 0) {
			for (int i = size - 1; i > stop - 1; i--) {
				if (num[i] > num[stop - 1]) {
					int temp = num[i];
					num[i] = num[stop - 1];
					num[stop - 1] = temp;
					break;
				}
			}
		}
		int end = (size - 1 + stop) / 2;
		for (int i = stop; i <= end; i++) {
			int j = size - 1 + stop - i;
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
	}

}
