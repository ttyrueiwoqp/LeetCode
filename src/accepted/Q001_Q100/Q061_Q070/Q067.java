package accepted.Q001_Q100.Q061_Q070;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q067 {

	public String addBinary(String a, String b) {

		StringBuilder sb = new StringBuilder();
		int aLen = a.length();
		int bLen = b.length();
		int carry = 0;

		if (aLen > bLen) {
			return addBinary(b, a);
		}

		for (int i = 1; i <= aLen; i++) {
			int digit = a.charAt(aLen - i) - '0' + b.charAt(bLen - i) - '0' + carry;
			int remain = digit % 2;
			sb.insert(0, remain);
			carry = digit / 2;
		}
		
		for (int i = aLen + 1; i <= bLen; i++) {
			int digit = b.charAt(bLen - i) - '0' + carry;
			int remain = digit % 2;
			sb.insert(0, remain);
			carry = digit / 2;
		}
		
		if (carry == 1) {
			sb.insert(0, "1");
		}

		return sb.toString();
	}

	@Test
	public void test() {
		assertEquals("100", addBinary("1", "11"));
		assertEquals("110110", addBinary("100", "110010"));
	}

}
