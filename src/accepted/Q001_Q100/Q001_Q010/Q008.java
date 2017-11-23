package accepted.Q001_Q100.Q001_Q010;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases.
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely
 * (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 */
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
