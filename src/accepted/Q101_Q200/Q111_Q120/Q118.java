package accepted.Q101_Q200.Q111_Q120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q118 {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		if (numRows == 0) {
			return res;
		}
		
		if (numRows == 1) {
			curr.add(1);
		} else {
			res = generate(numRows - 1);
			List<Integer> last = res.get(res.size() - 1);
			for (int i = 0; i < last.size() - 1; i++) {
				curr.add(last.get(i) + last.get(i + 1));
			}
			curr.add(0, 1);
			curr.add(1);
		}
		res.add(curr);

		return res;
	}

	@Test
	public void test() {
		System.out.println(generate(2));
	}

}
