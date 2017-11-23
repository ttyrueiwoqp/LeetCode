package accepted.Q301_Q400.Q331_Q340;

/**
 * Created by FJ on 3/18/2016.
 * <p/>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 * <p/>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p/>
 * Follow up:
 * <p/>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 * Hint:
 * <p/>
 * You should make use of what you have produced already.
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 */
public class Q338 {

	public int[] countBits(int num) {

		if (num < 0) {
			return new int[0];
		}

		int[] res = new int[num + 1];
		res[0] = 0;

		int i = 1, p = 1, cnt = p;
		while (i <= num) {
			res[i] = 1 + res[i - p];
			i++;
			cnt--;
			if (cnt == 0) {
				p *= 2;
				cnt = p;
			}
		}

		return res;
	}

}
