package accepted.Q001_Q100.Q031_Q040;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

public class Q036 {

	public boolean isValidSudoku(char[][] board) {

		Map<Character, Integer> h = new HashMap<Character, Integer>();
		List<Map<Character, Integer>> vList = new ArrayList<Map<Character, Integer>>();
		List<Map<Character, Integer>> sList = new ArrayList<Map<Character, Integer>>();
		for (int j = 0; j < board[0].length; j++) {
			vList.add(new HashMap<Character, Integer>());
			sList.add(new HashMap<Character, Integer>());
		}

		for (int i = 0; i < board.length; i++) {
			h.clear();
			for (int j = 0; j < board[i].length; j++) {
				char val = board[i][j];

				if (val != '.') {
					if (h.get(val) == null) {
						h.put(val, 0);
					} else {
						return false;
					}
					Map<Character, Integer> v = vList.get(j);
					if (v.get(val) == null) {
						v.put(val, 0);
					} else {
						return false;
					}
					Map<Character, Integer> s = sList.get(i / 3 * 3 + j / 3);
					if (s.get(val) == null) {
						s.put(val, 0);
					} else {
						return false;
					}
				}
			}
		}

		return true;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
