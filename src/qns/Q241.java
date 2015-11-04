package qns;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 11/3/2015.
 * <p>
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * <p>
 * <p>
 * Example 1
 * Input: "2-1-1".
 * <p>
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * <p>
 * <p>
 * Example 2
 * Input: "2*3-4*5"
 * <p>
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class Q241 {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();

		return res;
	}

	@Test
	public void test() {

	}
}
