package accepted.Q151_Q160;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FJ on 6/21/2015.
 * <p/>
 * Given an input string, reverse the string word by word.
 * <p/>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p/>
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * <p/>
 * click to show clarification.
 * <p/>
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class Q151 {
	public String reverseWords(String s) {

		char[] chars = s.toCharArray();
		List<String> strs = new ArrayList<>();

		boolean isUsefulWS = false;
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == ' ') {
				if (isUsefulWS) {
					strs.add(sb.toString());
					sb.setLength(0);
					isUsefulWS = false;
				}
			} else {
				isUsefulWS = true;
				sb.append(c);
			}
		}
		if (isUsefulWS) {
			strs.add(sb.toString());
		}

		if (strs.size() == 0) {
			return "";
		}

		sb.setLength(0);
		for (int i = strs.size() - 1; i >= 0; i--) {
			sb.append(strs.get(i)).append(' ');
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	@Test
	public void test() {
		System.out.println(reverseWords("  the   sky is blue  "));
		System.out.println(reverseWords(" "));
	}

}
