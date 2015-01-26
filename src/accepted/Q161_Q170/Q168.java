package accepted.Q161_Q170;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q168 {

	public String convertToTitle(int n) {
		
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.insert(0, (char)('A' + n % 26));
			n /= 26;
		}
		return sb.toString();

	}

	@Test
	public void test() {
		assertEquals("AA", convertToTitle(27));
		assertEquals("A", convertToTitle(1));
		assertEquals("Z", convertToTitle(26));
		assertEquals("BA", convertToTitle(53));
	}

}
