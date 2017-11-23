package accepted.Q001_Q100.Q061_Q070;

import org.junit.Test;

public class Q065 {

	public boolean isNumber(String s) {

		boolean hasDot = false;
		boolean hasE = false;
		boolean hasDigit = false;
		s = s.trim();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				hasDigit = true;
			} else {
				switch (c) {
				case '-':
				case '+':
					if (i > 0 && s.charAt(i - 1) != 'e') {
						return false;
					}
					break;
				case '.':
					if (hasDot || hasE) {
						return false;
					} else {
						hasDot = true;
					}
					break;
				case 'e':
					if (hasE || i == 0 || i == s.length() - 1 || !hasDigit) {
						return false;
					} else {
						hasE = true;
						hasDigit = false;
					}
					break;
				default:
					return false;
				}
			}
		}
		return hasDigit;
	}

	@Test
	public void test() {
	}

}
