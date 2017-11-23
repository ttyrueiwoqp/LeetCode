package accepted.Q301_Q400.Q341_Q350;

/**
 * Created by LU-PC on 4/19/2016.
 * <p>
 * Given an integer (signed 32 bits), write a function to check
 * whether it is a power of 4.
 * <p>
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 */
public class Q342 {

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & num - 1) == 0 && (0x55555555 & num) != 0;
    }
}
