package accepted.Q021_Q030;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Q022 {

	public List<String> generateParenthesis(int n) {
		return new ArrayList<String>(helper(n));
	}

	public Set<String> helper(int n) {

		Set<String> res = new HashSet<String>();

		if (n == 0) {
			res.add("");
			return res;
		}
		if (n == 1) {
			res.add("()");
			return res;
		}

		for (int i = 1; i < n; i++) {

			Set<String> ps = helper(i);
			Set<String> qs = helper(n - i);

			for (String p : ps) {
				for (String q : qs) {
					res.add(p + q);
				}
			}
			
			String pre = new String();
			String post = new String();
			for (int j = 0; j < i; j++) {
				pre += "(";
			}
			for (int j = 0; j < i; j++) {
				post += ")";
			}
			
			for (String q : qs) {
				res.add(pre + q + post);
			}
			
		}

		String ones = new String();
		String left = new String();
		String right = new String();
		for (int i = 0; i < n; i++) {
			ones += "()";
			left += "(";
			right += ")";
		}
		res.add(ones);
		res.add(left + right);

		return res;
	}

	@Test
	public void test() throws Exception {
		assertEquals(null, generateParenthesis(3));

	}
}
