package accepted.Q301_Q400.Q311_Q320;

import org.junit.Test;

/**
 * Created by FJ on 1/18/2016.
 * <p/>
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb.
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * <p/>
 * Example:
 * <p/>
 * Given n = 3.
 * <p/>
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 * <p/>
 * So you should return 1, because there is only one bulb is on.
 */
public class Q319 {
	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

	public int bulbSwitch2(int n) {

		int[] a = new int[n];
		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j+=i) {
				a[j] = 1 - a[j];
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			res += a[i];
		}
		return res;
	}

	@Test
	public void test() {
		System.out.println(bulbSwitch(9999999));
//		System.out.println(bulbSwitch2(9999999));
	}
}
