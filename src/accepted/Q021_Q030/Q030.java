package accepted.Q021_Q030;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Q030 {

	public List<Integer> findSubstring(String S, String[] L) {

		List<Integer> res = new ArrayList<Integer>();
		Map<String, Integer> m = new HashMap<String, Integer>();

		int len = L[0].length();
		for (String l : L) {
			Integer val = m.get(l);
			if (val == null) {
				m.put(l, 1);
			} else {
				m.put(l, val + 1);
			}
		}
		
		for (int i = 0; i < S.length(); i++) {
			Map<String, Integer> mc = new HashMap<String, Integer>(m);
			boolean exists = true;
			for (int j = 0; j < L.length; j++) {
				int idx = i + j * len;
				if (idx + len > S.length()) {
					exists = false;
					break;
				} else {
					String key = S.substring(idx, idx + len);
					Integer cnt = mc.get(key);
					if (cnt == null || cnt <= 0) {
						exists = false;
						break;
					} else {
						mc.put(key, cnt - 1);
					}
				}
			}
			if (exists) {
				res.add(i);
			}
		}

		return res;
	}

	@Test
	public void test() {

		String[] L = { "fooo", "barr", "wing", "ding", "wing" };
		assertEquals(
				null,
				findSubstring(
						"lingmindraboofooowingdingbarrwingmonkeypoundcake", L));

		String[] T = { "foo", "bar" };
		assertEquals(null, findSubstring("barfoothefoobarman", T));

		String[] a = { "a", "b" };
		assertEquals(null, findSubstring("aaa", a));
	}

}
