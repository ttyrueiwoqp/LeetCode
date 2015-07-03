package accepted.Q011_Q020;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Q017 {

	public List<String> letterCombinations(String digits) {

		List<String> res = new ArrayList<String>();

		if (digits == null || digits.isEmpty()) {
			res.add("");
			return res;
		}

		if (digits.length() == 1) {
			for (char c : getChars(digits.charAt(digits.length() - 1))
					.toCharArray()) {
				res.add(String.valueOf(c));
			}
		} else {
			List<String> prev = letterCombinations(digits.substring(0,
					digits.length() - 1));

			for (String p : prev) {
				for (char c : getChars(digits.charAt(digits.length() - 1))
						.toCharArray()) {
					res.add(p + c);
				}
			}
		}

		return res;
	}

	public String getChars(char digit) {

		String res = "";

		switch (digit) {
			case '0':
			case '1':
				break;
			case '2':
				res = "abc";
				break;
			case '3':
				res = "def";
				break;
			case '4':
				res = "ghi";
				break;
			case '5':
				res = "jkl";
				break;
			case '6':
				res = "mno";
				break;
			case '7':
				res = "pqrs";
				break;
			case '8':
				res = "tuv";
				break;
			case '9':
				res = "wxyz";
				break;
			default:
				break;
		}

		return res;
	}

	@Test
	public void test() throws Exception {
		assertEquals(0, letterCombinations("23"));
	}
}
