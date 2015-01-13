package accepted.Q001_Q020;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q014 {
	
	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			return "";
		}
		
		if (strs.length == 1) {
			return strs[0];
		}
		
		StringBuilder res = new StringBuilder();
		
		for (int i = 0; i < strs[0].length(); i++) {
			char curr = strs[0].charAt(i);
			
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || strs[j].charAt(i) != curr) {
					return res.toString();
				}
			}
			
			res.append(curr);
		}
		
		return res.toString();
	}
	
	@Test
	public void test() {
		String[] a = {"abcd", "abcde", "abcdefg"};
		assertEquals("abcd", longestCommonPrefix(a));
	}
	
}
