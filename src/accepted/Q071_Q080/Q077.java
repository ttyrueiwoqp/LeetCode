package accepted.Q071_Q080;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q077 {

	public List<List<Integer>> combine(int n, int k) {

		List<Integer> ns = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			ns.add(i);
		}
		return combine(ns, k, k);
	}

	private List<List<Integer>> combine(List<Integer> ns, int k, int idx) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int n = ns.size();

		if (idx == 1) {
			for (int i = idx; i <= n - k + idx; i++) {
				List<Integer> base = new ArrayList<Integer>();
				base.add(i);
				res.add(base);
			}
			return res;
		}
		
		List<Integer> curr = new ArrayList<Integer>();
		for (int i = idx; i <= n - k + idx; i++) {
			curr.add(i);
		}
		List<List<Integer>> prevRes = combine(ns, k, idx - 1);
		
		for (int i = 0; i < prevRes.size(); i++) {
			List<Integer> prev = prevRes.get(i);
			for (int j = 0; j < curr.size(); j++) {
				if (curr.get(j) > prev.get(prev.size() - 1)) {
					List<Integer> t = new ArrayList<Integer>(prev);
					t.add(curr.get(j));
					res.add(t);
				}
			}
		}

		return res;
	}

	@Test
	public void test() {

		System.out.println(combine(4, 3));

	}

}
