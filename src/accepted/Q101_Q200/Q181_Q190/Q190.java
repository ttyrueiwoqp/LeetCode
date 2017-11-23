package accepted.Q101_Q200.Q181_Q190;

/**
 * Created by LU-PC on 6/2/2015.
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * For example, given input 43261596
 * (represented in binary as 00000010100101000001111010011100),
 * return 964176192
 * (represented in binary as 00111001011110000010100101000000).
 * <p>
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class Q190 {
	public int reverseBits(int n) {
		return Integer.reverse(n);
	}
}
