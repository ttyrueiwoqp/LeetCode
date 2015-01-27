package accepted.Q111_Q120;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q119 {

	public List<Integer> getRow(int rowIndex) {

		List<Integer> res = new ArrayList<Integer>();

		if (rowIndex == 0) {
			res.add(1);
		} else {
			List<Integer> last = getRow(rowIndex - 1);
			for (int i = 0; i < last.size() - 1; i++) {
				res.add(last.get(i) + last.get(i + 1));
			}
			res.add(0, 1);
			res.add(1);
		}

		return res;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
