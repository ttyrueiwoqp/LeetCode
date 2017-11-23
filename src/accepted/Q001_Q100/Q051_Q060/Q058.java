package accepted.Q001_Q100.Q051_Q060;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
