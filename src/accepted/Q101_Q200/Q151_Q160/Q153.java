package accepted.Q101_Q200.Q151_Q160;

public class Q153 {

	public int findMin(int[] num) {
		return checkMin(num, 0, num.length - 1);
	}

	public int checkMin(int[] num, int st, int end) {
		int mid = (st + end) / 2;

		if (st == mid) {
			return num[st] < num[end] ? num[st] : num[end];
		}

		if (num[mid] < num[end]) {
			return checkMin(num, st, mid);
		} else {
			return checkMin(num, mid, end);
		}

	}

}
