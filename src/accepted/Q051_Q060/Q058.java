package accepted.Q051_Q060;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q058 {

	public int lengthOfLastWord(String s) {
		s = s.trim();
		return s.length() - 1 - s.lastIndexOf(' ');
	}

	@Test
	public void test() {
		assertEquals(0, lengthOfLastWord(""));
	}

}
