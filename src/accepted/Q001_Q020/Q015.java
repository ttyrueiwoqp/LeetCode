package accepted.Q001_Q020;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Q015 {

	public List<List<Integer>> threeSum1(int[] num) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3) {
			return res;
		}

		Arrays.sort(num);
		List<Integer> negative = new ArrayList<Integer>();
		List<Integer> positive = new ArrayList<Integer>();

		for (int i = 0; i < num.length; i++) {
			if (num[i] < 0) {
				negative.add(num[i]);
			} else {
				positive.add(num[i]);
			}
		}

		if (positive.size() > 2 && positive.get(2) == 0) {
			List<Integer> item = Arrays.asList(0, 0, 0);
			res.add(item);
		}

		for (int i = 0; i < negative.size(); i++) {
			int repeat = -1;
			int k = positive.size();
			for (int j = i + 1; j < negative.size(); j++) {
				while (k > 0) {
					k--;
					if (positive.get(k) == repeat) {
						continue;
					}

					int sum = negative.get(i) + negative.get(j)
							+ positive.get(k);
					if (sum == 0) {
						repeat = positive.get(k);
						List<Integer> item = new ArrayList<Integer>();
						item.add(negative.get(i));
						item.add(negative.get(j));
						item.add(positive.get(k));
						res.add(item);
					} else if (sum < 0) {
						k++;
						break;
					}
				}
			}
		}

		for (int i = 0; i < positive.size(); i++) {
			int repeat = 1;
			int k = negative.size();
			for (int j = i + 1; j < positive.size(); j++) {
				while (k > 0) {
					k--;
					if (negative.get(k) == repeat) {
						continue;
					}

					int sum = positive.get(i) + positive.get(j)
							+ negative.get(k);
					if (sum == 0) {
						repeat = negative.get(k);
						List<Integer> item = new ArrayList<Integer>();
						item.add(negative.get(k));
						item.add(positive.get(i));
						item.add(positive.get(j));
						res.add(item);
					} else if (sum < 0) {
						k++;
						break;
					}
				}
			}
		}

		return res;
	}
	
	public List<List<Integer>> threeSum2(int[] num) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3) {
			return res;
		}

		Map<Integer, Set<Triple>> m = new HashMap<Integer, Set<Triple>>();

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (i > 0 && num[i] == num[i - 1]) {
					continue;
				} else {
					int k = -(num[i] + num[j]);
					if (k >= 0) {
						Set<Triple> tset = m.get(k);
						if (tset == null) {
							m.put(k, new HashSet<Triple>());
							tset = m.get(k);
						}
						Triple triple = new Triple();
						if (num[i] > num[j]) {
							triple.x = num[j];
							if (k < num[i]) {
								triple.y = k;
								triple.z = num[i];
							} else {
								triple.y = num[i];
								triple.z = k;
							}
						} else {
							triple.x = num[i];
							if (k < num[j]) {
								triple.y = k;
								triple.z = num[j];
							} else {
								triple.y = num[j];
								triple.z = k;
							}
						}
						tset.add(triple);
					}
				}
			}
		}

		Set<Triple> resSet = new HashSet<Triple>();
		for (int k = 0; k < num.length; k++) {
			if (num[k] >= 0) {
				Set<Triple> tset = m.get(num[k]);
				if (tset != null) {
					for (Triple triple : tset) {
						resSet.add(triple);
					}
				}
			}
		}
		
		for (Triple triple : resSet) {
			List<Integer> item = new ArrayList<Integer>();
			item.add(triple.x);
			item.add(triple.y);
			item.add(triple.z);
			res.add(item);
		}

		return res;
	}

	private class Triple {
		int x;
		int y;
		int z;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			result = prime * result + z;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triple other = (Triple) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			if (z != other.z)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Triple [x=" + x + ", y=" + y + ", z=" + z + "]";
		}

	}

	public List<List<Integer>> threeSum(int[] num) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3) {
			return res;
		}
		Arrays.sort(num);
		
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < num.length; j++) {
				if (j > i + 1 && num[j] == num[j - 1]) {
					continue;
				}	
				for (int k = num.length - 1; k > j; k--) {
					if (k < num.length - 1 && num[k] == num[k + 1]) {
						continue;
					}
					if (num[i] + num[j] + num[k] == 0) {
						List<Integer> item = new ArrayList<Integer>();
						item.add(num[i]);
						item.add(num[j]);
						item.add(num[k]);
						res.add(item);
					}
				}
			}
		}
		
		return res;
	}
	
	@Test
	public void test() {

		List<Integer> m = Arrays.asList(-1, 0, 1);
		List<Integer> n = Arrays.asList(-1, -1, 2);

		List<List<Integer>> a = new ArrayList<List<Integer>>();
		a.add(m);
		a.add(n);

		int[] s = { 0,7,-4,-7,0,14,-6,-4,-12,11,4,9,7,4,-10,8,10,5,4,14,6,0,-9,5,6,6,-11,1,-8,-1,2,-1,13,5,-1,-2,4,9,9,-1,-3,-1,-7,11,10,-2,-4,5,10,-15,-4,-6,-8,2,14,13,-7,11,-9,-8,-13,0,-1,-15,-10,13,-2,1,-1,-15,7,3,-9,7,-1,-14,-10,2,6,8,-6,-12,-13,1,-3,8,-9,-2,4,-2,-3,6,5,11,6,11,10,12,-11,-14 };
		Arrays.sort(s);
		System.out.println(s);

		int[] t = { -2, 0, 1, 1, 2 };
		assertEquals(a, threeSum(t));

	}
}
