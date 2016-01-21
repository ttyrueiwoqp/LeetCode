package accepted.Q321_Q330;

import org.junit.Test;

/**
 * Created by FJ on 1/21/2016.
 * <p/>
 * Given an integer, write a function to determine if it is a power of three.
 * <p/>
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class Q326 {

	public boolean isPowerOfThree(int n) {
		String nStr = Integer.toString(n, 3);
		return n > 0 && nStr.charAt(0) == '1' && (nStr.length() <= 1 || Long.parseLong(nStr.substring(1)) == 0);
//		return Integer.toString(n, 3).matches("10*");

	}

	@Test
	public void test() {
//		System.out.println(Integer.toString(3, 3));
//		System.out.println(Integer.toString(9,3));
//		System.out.println(Integer.toString(27,3));
//		System.out.println(Integer.toString(81,3));

		System.out.println(isPowerOfThree(1));
		System.out.println(isPowerOfThree(3));
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(81));
		System.out.println(isPowerOfThree(2147483647));
	}
}
