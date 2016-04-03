package accepted.Q241_Q250;

import org.junit.Test;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * <p>
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Q246 {

    public boolean isStrobogrammatic(String num) {
        int[] a = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

        int i = 0, j = num.length() - 1;
        while (j >= i) {
            if (a[num.charAt(i) - '0'] != num.charAt(j) - '0') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test() {
        isStrobogrammatic("1");
    }

    public boolean sln(String num) {
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;
    }
}
