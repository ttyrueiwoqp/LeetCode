package qns;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q046 {

	public List<List<Integer>> permute(int[] num) {

		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			numList.add(num[i]);
		}
		
		return permute(new ArrayList<Integer>(), numList);
	}
	
	public List<List<Integer>> permute(List<Integer> fList, List<Integer> vList) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (vList.size() == 1) {
			fList.addAll(vList);
			res.add(fList);
			return res;
		}
		
		for (int i = 0; i < vList.size(); i++) {
			List<Integer> newFList = new ArrayList<Integer>(fList);
			newFList.add(vList.get(i));
			List<Integer> newVList = new ArrayList<Integer>(vList);
			newVList.remove(i);
			res.addAll(permute(newFList, newVList));
		}
		
		return res;
	}

	@Test
	public void test() {
		
		int[] num = {1, 2, 3};
		System.out.println(permute(num));
	}

}
