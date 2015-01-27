package accepted.Q051_Q060;

import org.junit.Test;

public class Q059 {

	public int[][] generateMatrix(int n) {
		int ns = n * n;
		int[][] res = new int[n][n];
		
		int i = 0, j = 0, k = 1, dir = 0;
		int hMin = 0, hMax = n - 1, vMin = 0, vMax = n - 1;
		while (k <= ns) {
			res[i][j] = k;
			switch (dir) {
			case 0:
				if (j == hMax) {
					dir = 1;
					i++;
					hMax--;
				} else {
					j++;
				}
				break;
			case 1:
				if (i == vMax) {
					dir = 2;
					j--;
					vMax--;
				} else {
					i++;
				}
				break;
			case 2:
				if (j == hMin) {
					dir = 3;
					i--;
					hMin++;
				} else {
					j--;
				}
				break;
			case 3:
				if (i == vMin + 1) {
					dir = 0;
					j++;
					vMin++;
				} else {
					i--;
				}
				break;
			default:
				break;
			}

			k++;
		}
		return res;

	}

	@Test
	public void test() {
		System.out.println(generateMatrix(2));
	}

}
