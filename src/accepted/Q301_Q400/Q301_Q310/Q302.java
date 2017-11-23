package accepted.Q301_Q400.Q301_Q310;

import org.junit.Test;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region.
 * Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels,
 * return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * <p>
 * For example, given the following image:
 * <p>
 * [
 * "0010",
 * "0110",
 * "0100"
 * ]
 * and x = 0, y = 2,
 * Return 6.
 */
public class Q302 {

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;

        int left = searchCol(0, y, 0, m, image, true);
        int right = searchCol(y + 1, n, 0, m, image, false);
        int top = searchRow(0, x, left, right, image, true);
        int bottom = searchRow(x + 1, m, left, right, image, false);

        return (right - left) * (bottom - top);
    }

    private int searchCol(int i, int j, int top, int bottom, char[][] image, boolean dir) {

        while (i < j) {
            int k = (i + j) / 2, row = top;
            while (row < bottom && image[row][k] == '0') {
                row++;
            }
            if (row < bottom == dir) {
                j = k;
            } else {
                i = k + 1;
            }
        }

        return i;
    }

    private int searchRow(int i, int j, int left, int right, char[][] image, boolean dir) {
        while (i < j) {
            int k = (i + j) / 2, col = left;
            while (col < right && image[k][col] == '0') {
                col++;
            }
            if (col < right == dir) {
                j = k;
            } else {
                i = k + 1;
            }
        }

        return i;
    }

    // TODO: Subscribe again and check solution
    @Test
    public void test() {
        char[][] a = new char[][]{
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'}
        };
        System.out.println(minArea(a, 0, 2));
    }


    private char[][] image;

    public int sln(char[][] iImage, int x, int y) {
        image = iImage;
        int m = image.length, n = image[0].length;
        int left = searchColumns(0, y, 0, m, true);
        int right = searchColumns(y + 1, n, 0, m, false);
        int top = searchRows(0, x, left, right, true);
        int bottom = searchRows(x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }

    private int searchColumns(int i, int j, int top, int bottom, boolean opt) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') ++k;
            if (k < bottom == opt)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }

    private int searchRows(int i, int j, int left, int right, boolean opt) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') ++k;
            if (k < right == opt)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}
