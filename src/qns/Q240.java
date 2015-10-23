package qns;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			int curr = get(matrix, iMid, jMid);

			if (curr == target) {
				return true;
			}

			if (curr < target) {
				iSt = (iMid + 1 < matrix.length) ? iMid + 1 : iMid;
				jSt = (jMid + 1 < matrix[0].length) ? jMid + 1 : jMid;

			} else {
				iEnd =  iMid;
				jEnd =  jMid;
			}

		}

		if (matrix[iSt][jSt] == target) {
			return true;
		}

		return false;
	}

	private int get(int[][] matrix, int i, int j) {
		if (i < 0) {
			i = 0;
		} else if (i > matrix.length - 1) {
			i = matrix.length - 1;
		}

		if (j < 0) {
			j = 0;
		} else if (j > matrix.length - 1) {
			j = matrix.length - 1;
		}

		return matrix[i][j];
	}


	@Test
	public void test() {
//		int[][] a = {
//				{1, 4, 7, 11, 15},
//				{2, 5, 8, 12, 19},
//				{3, 6, 9, 16, 22},
//				{10, 13, 14, 17, 24},
//				{18, 21, 23, 26, 30}
//		};
//		int[][] b = {
//				{1, 4, 7, 11, 15, 18, 20},
//				{2, 5, 8, 12, 19, 23, 26},
//				{3, 6, 9, 16, 22, 25, 28},
//				{10, 13, 14, 17, 24, 30, 32}
//		};

//		for (int i = 0; i < 33; i++) {
//			if (searchMatrix(b, i)) {
//				System.out.println(i);
//			}
//		}
//		searchMatrix(b, 7);

	}

}
