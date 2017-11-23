package accepted.Q201_Q300.Q241_Q250;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by LU-PC on 10/8/2015.
 * <p>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class Q242 {
	public boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		Arrays.sort(sArr);
		Arrays.sort(tArr);

		return isEqual(sArr, tArr);
	}

	private boolean isEqual(char[] sArr, char[] tArr) {
		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i] != tArr[i]) {
				return false;
			}
		}
		return true;
	}


	@Test
	public void test() {
		String s = "anagram", t = "nagaram";
		System.out.println(isAnagram(s, t));
	}
}
