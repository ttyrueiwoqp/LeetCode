package accepted.Q001_Q100.Q081_Q090;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FJ on 11/13/2015.
 * <p/>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p/>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * <p/>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p/>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p/>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p/>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class Q089 {

	public List<Integer> grayCode(int n) {

		List<Integer> res = new ArrayList<>();
		if (n == 0) {
			res.add(0);
			return res;
		}

		List<Integer> nexts = grayCode(n - 1);
		res.addAll(nexts);
		for (int i = nexts.size() - 1; i >= 0; i--) {
			 res.add(nexts.get(i) + (1 << n-1));
		}
		return res;
	}

	@Test
	public void test() {
		System.out.println(grayCode(2));
	}
}
