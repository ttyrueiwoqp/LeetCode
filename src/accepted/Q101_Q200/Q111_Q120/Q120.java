package accepted.Q101_Q200.Q111_Q120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q120 {

	public int minimumTotal(List<List<Integer>> triangle) {

		List<List<Integer>> sum = new ArrayList<List<Integer>>(triangle);
		for (int i = 1; i < sum.size(); i++) {
			List<Integer> currRow = sum.get(i);
			List<Integer> lastRow = sum.get(i - 1);
			currRow.set(0, currRow.get(0) + lastRow.get(0));
			currRow.set(currRow.size() - 1, currRow.get(currRow.size() - 1) + lastRow.get(lastRow.size() - 1));
			for (int j = 1; j < currRow.size() - 1; j++) {
				int min = Math.min(lastRow.get(j), lastRow.get(j - 1));
				currRow.set(j, currRow.get(j) + min);
			}
		}
		
		List<Integer> endRow = sum.get(sum.size() - 1); 
		int res = endRow.get(0);
		for (int j = 1; j < endRow.size(); j++) {
			int val = endRow.get(j);
			if (val < res) {
				res = val;
			}
		}
		return res;
	}

	public int minimumTotal(List<List<Integer>> triangle, int lvl, int idx) {

		int curr = triangle.get(lvl).get(idx);
		if (lvl >= triangle.size() - 1) {
			return curr;
		}
		return curr
				+ Math.min(minimumTotal(triangle, lvl + 1, idx),
						minimumTotal(triangle, lvl + 1, idx + 1));
	}

	@Test
	public void test() {
		Random r = new Random();
		List<List<Integer>> t = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++) {
			curr.add(r.nextInt(100));
			t.add(new ArrayList<Integer>(curr));
			System.out.println(curr);
		}
		System.out.println(minimumTotal(t));
	}

}
