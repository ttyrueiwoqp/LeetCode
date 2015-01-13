package accepted.Q001_Q020;

import java.util.ArrayList;
import java.util.List;

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
