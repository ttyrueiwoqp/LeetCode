package accepted.Q001_Q010;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Q006 {

	public String convert(String s, int nRows) {

		if (nRows == 1) {
			return s;
		}

		List<StringBuilder> strList = new ArrayList<StringBuilder>();

		for (int i = 0; i < nRows; i++) {
			strList.add(new StringBuilder());
		}

		int strIdx = 0;
		int listIdx = 0;
		int change = 1;
		while (strIdx < s.length()) {
			strList.get(listIdx).append(s.charAt(strIdx));

			if (listIdx == nRows - 1) {
				change = -1;
			} else if (listIdx == 0) {
				change = 1;
			}
			listIdx += change;
			strIdx++;
		}

		StringBuilder result = new StringBuilder();
		for (StringBuilder sb : strList) {
			result.append(sb);
		}

		return result.toString();
	}

}
