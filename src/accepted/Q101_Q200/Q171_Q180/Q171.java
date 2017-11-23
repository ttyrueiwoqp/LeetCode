package accepted.Q101_Q200.Q171_Q180;

import org.junit.Test;

public class Q171 {

	public int titleToNumber(String s) {
	
		int sum = 0;
		int multiply = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			sum += (s.charAt(i) - 'A' + 1) * multiply;
			multiply *= 26;
		}
		
		return sum;
    }
	
	
	
	@Test
	public void test() {
	}

}
