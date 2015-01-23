package accepted.Q041_Q050;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class Q049 {

	public List<String> anagrams(String[] strs) {
		
		Map<String, List<String>> pool = new HashMap<String, List<String>>();
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < strs.length; i++) {
			char[] strArr = strs[i].toCharArray();
			Arrays.sort(strArr);
			String s = String.valueOf(strArr);
			if (!pool.containsKey(s)) {
			    pool.put(s, new ArrayList<String>());
			}
			pool.get(s).add(strs[i]);
			
		}
		
		for (Entry<String, List<String>> e : pool.entrySet()) {
			List<String> val = e.getValue();
			if (val.size() > 1) {
				res.addAll(val);
			}
		}
		
		return res;
	}

	@Test
	public void test() {
		char[] a = {'b', 'c', 'a'};
		Arrays.sort(a);
		System.out.println(a);
		
		String[] b = {"", ""};
		System.out.println(anagrams(b));
	}

}
