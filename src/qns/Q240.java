package qns;

import org.junit.Test;

/**
 * Created by LU-PC on 10/21/2015.
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class Q240 {

	public boolean searchMatrix(int[][] matrix, int target) {
		int iSt = 0, iEnd = matrix.length - 1, jSt = 0, jEnd = matrix[0].length - 1;

		while (!(iSt == iEnd && jSt == jEnd)) {
			int iMid = (iSt + iEnd) / 2, jMid = (jSt + jEnd) / 2;

			if (matrix[iMid][jMid] == target) {
				return true;
			}

			if (matrix[iMid][jMid] < target) {
				iSt = (iMid + 1 < matrix.length) ? iMid + 1 : iMid;
				jSt = (jMid + 1 < matrix[0].length) ? jMid + 1 : jMid;

			} else {
				iEnd = (iMid - 1 >= 0) ? iMid - 1 : iMid;
				jEnd = (jMid - 1 >= 0) ? jMid - 1 : jMid;
			}

		}

		if (matrix[iSt][jSt] == target) {
			return true;
		}

		return false;
	}

	private boolean search(int[][] matrix, int prevIMid, int prevJMid, int target) {

//		System.out.println(prevIMid + " " + prevJMid);
		for (int i = 0; i < prevJMid; i++) {
			if (matrix[i][prevJMid] == target) {
				return true;
			}
		}
		for (int j = 0; j < prevIMid; j++) {
			if (matrix[prevIMid][j] == target) {
				return true;
			}
		}

		return false;
	}


	@Test
	public void test() {
		int[][] a = {
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		int[][] b = {
				{1, 4, 7, 11, 15, 18, 20},
				{2, 5, 8, 12, 19, 23, 26},
				{3, 6, 9, 16, 22, 25, 28},
				{10, 13, 14, 17, 24, 30, 32}
		};

//		for (int i = 0; i < 33; i++) {
//			if (searchMatrix(b, i)) {
//				System.out.println(i);
//			}
//		}
		searchMatrix(b, 7);
	}

}
