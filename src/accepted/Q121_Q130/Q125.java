package accepted.Q121_Q130;

public class Q125 {

	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.isEmpty()) {
			return true;
		}

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (!Character.isLetterOrDigit(s.charAt(start))) {
				start++;
			} else if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			} else if (!s.substring(start, start + 1).equalsIgnoreCase(
					s.substring(end, end + 1))) {
				return false;
			} else {
				start++;
				end--;
			}
		}

		return true;
	}

}
