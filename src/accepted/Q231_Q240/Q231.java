package accepted.Q231_Q240;

/**
 * Created by LU-PC on 7/6/2015.
 * <p>
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Q231 {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & n - 1) == 0;
	}
}
