package accepted.Q201_Q300.Q291_Q300;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FJ on 11/1/2015.
 * <p/>
 * You are playing the following Bulls and Cows game with your friend: You write a 4-digit secret number and
 * ask your friend to guess it, each time your friend guesses a number, you give a hint,
 * the hint tells your friend how many digits are in the correct positions (called "bulls")
 * and how many digits are in the wrong positions (called "cows"),
 * your friend will use those hints to find out the secret number.
 * <p/>
 * For example:
 * <p/>
 * Secret number:  1807
 * Friend's guess: 7810
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * According to Wikipedia: "Bulls and Cows (also known as Cows and Bulls or Pigs and Bulls or Bulls and Cleots)
 * is an old code-breaking mind or paper and pencil game for two or more players, predating the similar commercially
 * marketed board game Mastermind. The numerical version of the game is usually played with 4 digits,
 * but can also be played with 3 or any other number of digits."
 * <p/>
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows, in the above example, your function should return 1A3B.
 * <p/>
 * You may assume that the secret number and your friend's guess only contain digits,
 * and their lengths are always equal.
 */
public class Q299 {

	public String getHint(String secret, String guess) {

		int a = 0, b = 0;
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < secret.length(); i++) {
			char c = secret.charAt(i);
			Integer cnt = m.get(c);
			if (cnt == null) {
				m.put(c, 1);
			} else {
				m.put(c, cnt + 1);
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			char c = guess.charAt(i);
			Integer cnt = m.get(c);
			if (cnt != null) {
				if (c == secret.charAt(i)) {
					a++;
					if (cnt > 0) {
						m.put(c, cnt - 1);
					} else {
						b--;
					}
				} else {
					if (cnt > 0) {
						b++;
						m.put(c, cnt - 1);
					}
				}
			}
		}

		return a + "A" + b + "B";
	}

	@Test
	public void test() {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1234", "0111"));
		System.out.println(getHint("1122", "1222"));
	}
}
