package accepted.Q031_Q040;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q038 {

	public String countAndSay(int n) {

		String nStr = "1";
		
		for (int i = 0; i < n - 1; i++) {
			nStr = reads(nStr);
		}
		
		return nStr;
	}

	public String reads(String n) {

		if (n.length() == 1) {
			return "1" + n;
		}

		String res = "";
		int cnt = 1;
		int idx = 1;
		while (idx < n.length()) {
			if (n.charAt(idx) == n.charAt(idx - 1)) {
				cnt++;
			} else {
				res += cnt;
				res += n.charAt(idx - 1);
				cnt = 1;
			}
			idx++;
		}
		res += cnt;
		res += n.charAt(idx - 1);

		return res;
	}

	@Test
	public void test() {
		assertEquals("1", countAndSay(1));
		assertEquals("11", countAndSay(2));
		
		assertEquals("11", reads("1"));
		assertEquals("21", reads("11"));
		assertEquals("1211", reads("21"));
	}

}
