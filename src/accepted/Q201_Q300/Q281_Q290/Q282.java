package accepted.Q201_Q300.Q281_Q290;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FJ on 3/19/2016.
 * <p/>
 * Given a string that contains only digits 0-9 and a target value,
 * return all possibilities to add binary operators (not unary) +, -, or *
 * between the digits so they evaluate to the target value.
 * <p/>
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 */
public class Q282 {

	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		helper(res, num, target, "", 0, 0, 0);
		return res;
	}

	public void helper(List<String> res, String num, int target, String s, int i, long eval, long prev) {
		if (i == num.length()) {
			if (target == eval) {
				res.add(s);
			}
			return;
		}

		for (int j = i; j < num.length(); j++) {
			if (j != i && num.charAt(i) == '0') {
				break;
			}
			long curr = Long.parseLong(num.substring(i, j + 1));
			if (i == 0) {
				helper(res, num, target, s + curr, j + 1, curr, curr);
			} else {
				helper(res, num, target, s + "+" + curr, j + 1, eval + curr, curr);
				helper(res, num, target, s + "-" + curr, j + 1, eval - curr, -curr);
				helper(res, num, target, s + "*" + curr, j + 1, eval - prev + prev * curr, prev * curr);
			}
		}
	}

	@Test
	public void test() {
		System.out.println(addOperators("1034", 107));
	}

}
