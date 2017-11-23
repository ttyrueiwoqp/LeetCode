package accepted.Q001_Q100.Q041_Q050;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q043 {

	public String multiply(String num1, String num2) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4-num1.length() % 4; i++) {
			sb.append(0);
		}
		num1 = sb.append(num1).toString();
		sb.setLength(0);
		for (int i = 0; i < 4-num2.length() % 4; i++) {
			sb.append(0);
		}
		num2 = sb.append(num2).toString();
		sb.setLength(0);
		
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < num1.length() + num2.length(); i += 4) {
			res.add(0);
		}

		for (int i = num1.length(); i >= 4; i -= 4) {
			for (int j = num2.length(); j >= 4; j -= 4) {
				int m = Integer.parseInt(num1.substring(i - 4, i));
				int n = Integer.parseInt(num2.substring(j - 4, j));
				int idx = (num1.length() - i + num2.length() - j) / 4;
				int prod = m*n;
				int t1 = prod % 10000 + res.get(idx);
				int t2 = prod / 10000 + res.get(idx + 1);
				if (t1 >= 10000) {
					t2 += 1;
					t1 -= 10000;
				}
				if (t2 >= 10000) {
					res.set(idx + 2, res.get(idx + 2) + 1);
					t2 -= 10000;
				}
				res.set(idx, t1);
				res.set(idx + 1, t2);
			}
		}

		for (int i = res.size() - 1; i >= 0; i--) {
			sb.append(appendZeros(res.get(i)));
		}
		
		int i = 0;
		while (i < sb.length() - 1 && sb.charAt(i) == '0') {
			i++;
		}

		return sb.substring(i);
	}

	private StringBuilder appendZeros(int n) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		while (sb.length() < 4) {
			sb.insert(0, '0');
		}
		return sb;
	}

	@Test
	public void test() {
		assertEquals("0", multiply("0", "0"));
		assertEquals("1000000000000000000000000", multiply("1000000000000", "1000000000000"));
	}

}
