package accepted;

public class Q008 {
	
	public int atoi(String str) {

		str = str.trim();
		int result = 0;
		int sign = 1;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (i == 0 && c == '+') {

			} else if (i == 0 && c == '-') {
				sign = -1;
			} else if (c >= '0' && c <= '9') {
				int incr = c - '0';
				if (Integer.MAX_VALUE / 10 < result
						|| (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < incr)) {
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				result *= 10;
				result += incr;
			} else {
				return sign * result;
			}
		}

		return sign * result;
	}
}
