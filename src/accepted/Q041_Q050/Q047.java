package accepted.Q041_Q050;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Q047 {

	public List<List<Integer>> permuteUnique(int[] num) {

		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			numList.add(num[i]);
		}
		
		return new ArrayList<List<Integer>>(permute(new ArrayList<Integer>(), numList));
	}
	
	public Set<List<Integer>> permute(List<Integer> fList, List<Integer> vList) {

		Set<List<Integer>> res = new HashSet<List<Integer>>();
		if (vList.size() == 1) {
			fList.addAll(vList);
			res.add(fList);
			return res;
		}
		
		Set<Integer> processed = new HashSet<Integer>();
		for (int i = 0; i < vList.size(); i++) {
			Integer val = vList.get(i);
			if (processed.contains(val)) {
				continue;
			}
			processed.add(val);
			
			List<Integer> newFList = new ArrayList<Integer>(fList);
			newFList.add(vList.get(i));
			List<Integer> newVList = new ArrayList<Integer>(vList);
			newVList.remove(i);
			res.addAll(permute(newFList, newVList));
		}
		
		return res;
	}

	@Test
	public void test() throws Exception {
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(4);
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(4);
		
		Set<List<Integer>> c = new HashSet<List<Integer>>();
		c.add(a);
		c.add(b);
		
		System.out.println(c);
		
		int[] num = {3,3,0,0,2,3,2};
		System.out.println(permuteUnique(num).size());
		
	}

}
