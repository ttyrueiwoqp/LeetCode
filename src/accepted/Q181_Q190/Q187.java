package accepted.Q181_Q190;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LU-PC on 5/28/2015.
 * <p>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
 * repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule.
 * <p>
 * For example,
 * <p>
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * <p>
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class Q187 {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		Set<String> strSet = new HashSet<>();
		Set<String> strSet2 = new HashSet<>();

		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			if (strSet.contains(sub)) {
				strSet2.add(sub);
			} else {
				strSet.add(sub);
			}
		}

		res.addAll(strSet2);
		return res;
	}

	@Test
	public void test() {
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
