package accepted.Q001_Q100.Q031_Q040;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q037 {

	public void solveSudoku(char[][] board) {
		char[][] copy = solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = copy[i][j];
			}
		}
	}

	public char[][] solve(char[][] board) {

		char[][] copy = copyOf(board);
		
		List<Set<Character>> hList = new ArrayList<Set<Character>>();
		List<Set<Character>> vList = new ArrayList<Set<Character>>();
		List<Set<Character>> sList = new ArrayList<Set<Character>>();

		for (int j = 0; j < copy[0].length; j++) {
			hList.add(new HashSet<Character>());
			vList.add(new HashSet<Character>());
			sList.add(new HashSet<Character>());
		}

		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				char val = copy[i][j];
				if (copy[i][j] != '.') {
					hList.get(i).add(val);
					vList.get(j).add(val);
					sList.get(i / 3 * 3 + j / 3).add(val);
				}
			}
		}

		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				if (copy[i][j] == '.') {

					for (char k = '1'; k <= '9'; k++) {
						if (hList.get(i).contains(k)
								|| vList.get(j).contains(k)
								|| sList.get(i / 3 * 3 + j / 3).contains(k)) {
							continue;
						} else {
							copy[i][j] = k;
							char[][] res = solve(copy);
							if (res != null) {
								return res;
							} else {
								continue;
							}
						}
					}
					return null;
				}
			}
		}

		return copy;
	}

	private char[][] copyOf(char[][] arr) {
		char[][] newArr = new char[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i].clone();
		}
		return newArr;
	}
	
	private void vary(char[] a) {
		char[] copy = new char[a.length];
		copy[0] = '1';
		a = copy;
		a[0] = '1';
	}

	@Test
	public void test() {
		
		char[] b = {'0', '1'};
		vary(b);
		System.out.println(b);
		

		 String[] ss = { "..9748...", "7........", ".2.1.9...", "..7...24.",
		 ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.." };

		// String[] ss = { "519748632", "783652419", "426139875", "357986241",
		// "264317598", "198524367", "9..8.3.2.", "........6", "...2759.." };

//		String[] ss = { "519748632", "783652419", "426139875", "357986241",
//				"264317598", "198524367", "975863124", "832491756", "641275..." };
		
		char[][] a = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				a[i][j] = ss[i].charAt(j);
			}
		}
		a = solve(a);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
