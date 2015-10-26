package accepted.Q231_Q240;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LU-PC on 10/21/2015.
 * <p/>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p/>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p/>
 * Consider the following matrix:
 * <p/>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p/>
 * Given target = 20, return false.
 */
public class Q240 {

	public boolean searchMatrix(int[][] matrix, int target) {

		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}

		return false;
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
		int[][] b = {
				{1, 4, 7, 11, 15, 18, 20},
				{2, 5, 8, 12, 19, 23, 26},
				{3, 6, 9, 16, 22, 25, 28},
				{10, 13, 14, 17, 24, 30, 32}
		};

		for (int i = 0; i < 33; i++) {
			if (!searchMatrix(b, i)) {
				System.out.println(i);
			}
		}

	}

}
