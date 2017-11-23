package accepted.Q001_Q100.Q021_Q030;

public class Q028 {

	public String strStr(String haystack, String needle) {
        return haystack.contains(needle) ? haystack.substring(haystack.indexOf(needle)) : null;
    }
	
}
