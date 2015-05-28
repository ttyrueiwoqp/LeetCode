package accepted.Q091_Q100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by LU-PC on 5/28/2015.
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Q093 {
	public List<String> restoreIpAddresses(String s) {
		if (!hasValidLength(s, 4)) {
			return new ArrayList<>();
		}

		return findIPs(s, 4);
	}

	private List<String> findIPs(String s, int numParts) {

		List<String> res = new ArrayList<>();

		if (numParts == 1) {
			if (isValidInt(s)) {
				res.add(s);
			}
			return res;
		}

		int partLength = Math.min(3, s.length() - 1);
		for (int i = 1; i <= partLength; i++) {

			String subStr1 = s.substring(0, i);
			String subStr2 = s.substring(i);

			if (isValidInt(subStr1) && hasValidLength(subStr2, numParts - 1)) {
				List<String> temps = findIPs(subStr2, numParts - 1);
				res.addAll(temps.stream().map(temp -> subStr1 + "." + temp).collect(Collectors.toList()));
			}
		}

		return res;

	}

	private boolean isValidInt(String a) {
		int aInt = Integer.parseInt(a);
		return aInt >= 0 && aInt < 256 && Integer.toString(aInt).equals(a);
	}

	private boolean hasValidLength(String s, int numParts) {
		return numParts <= s.length() && s.length() <= numParts * 3;
	}

	@Test
	public void test() {
		String s = "25525511135";
		System.out.println(restoreIpAddresses(s));
		s = "1113511135";
		System.out.println(restoreIpAddresses(s));
		s = "0000";
		System.out.println(restoreIpAddresses(s));
		s = "010010";
		System.out.println(restoreIpAddresses(s));
	}

}
