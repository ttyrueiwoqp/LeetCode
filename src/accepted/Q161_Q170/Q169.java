package accepted.Q161_Q170;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Q169 {

	public int majorityElement(int[] num) {
		
		if (num.length == 1) {
			return num[0];
		}
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			Integer val = m.get(num[i]);
			if (val != null) {
				if (val + 1 > num.length / 2) {
					return num[i]; 
				}
				m.put(num[i], val+1);
				
			} else {
				m.put(num[i], 1);
			}
		}
		
		return -1;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
