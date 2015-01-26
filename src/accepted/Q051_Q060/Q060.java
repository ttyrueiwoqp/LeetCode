package accepted.Q051_Q060;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q060 {

	public String getPermutation(int n, int k) {
		
		String res = "";
		k--;
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		
		int[] fac = getFac(n);
		
		for (int i = n - 1; i >= 0; i--) {
			int d = k / fac[i];
			k %= fac[i];
			res += nums.get(d);
			nums.remove(d);
		}
		
		return res;
	}

	private int[] getFac(int n) {
		int[] fac = new int[n];
		fac[0] = 1;
		for (int i = 1; i < n; i++) {
			fac[i] = fac[i - 1] * i;
		}
		
		return fac;
	}

	@Test
	public void test() {
		
		int[] fac = {1, 1, 2, 6, 24};
		assertArrayEquals(fac, getFac(5));
		
		assertEquals("2341", getPermutation(4, 10));
	}

}
