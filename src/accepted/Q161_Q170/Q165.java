package accepted.Q161_Q170;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Q165 {

	public int compareVersion(String version1, String version2) {

		String[] v1 = version1.split("\\.", 0);
		String[] v2 = version2.split("\\.", 0);
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		int len = Math.max(v1.length, v2.length);
		for (int i = 0; i < len; i++) {
			l1.add(i < v1.length ? Integer.parseInt(v1[i]) : 0);
			l2.add(i < v2.length ? Integer.parseInt(v2[i]) : 0);
		}

		int i = 0;
		int res = 0;
		while (i < len) {
			res = l1.get(i).compareTo(l2.get(i));
			if (res == 0) {
				i++;
			} else {
				return res;
			}
		}

		return res;
	}

	@Test
	public void test() {

		Set<Double> a = new HashSet<Double>();
		a.add(3.33);
		a.add(3.330);
		a.add(3.333);

		String[] temp = "1".split("\\.", 0);
		System.out.println(temp.length);

		assertEquals(0, compareVersion("1.0", "1"));

	}

}
