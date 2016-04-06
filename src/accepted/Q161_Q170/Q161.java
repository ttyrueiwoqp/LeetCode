package accepted.Q161_Q170;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class Q161 {

    public boolean isOneEditDistance(String s, String t) {

        int s1 = -1, s2 = s.length(), t1 = -1, t2 = t.length();
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();

        if (Math.abs(s2 - t2) > 1) {
            return false;
        }

        while (s1 < s2 - 1 && t1 < t2 - 1 && sArr[s1 + 1] == tArr[t1 + 1]) {
            s1++;
            t1++;
        }

        // equals
        if (s2 == t2 && s1 == s2 - 1) {
            return false;
        }

        while (s2 > 0 && t2 > 0 && sArr[s2 - 1] == tArr[t2 - 1]) {
            s2--;
            t2--;
        }

        return Math.max(s2 - s1, t2 - t1) < 3;
    }

    public boolean sln(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() == t.length()) return isOneModify(s, t);
        if (s.length() > t.length()) return isOneDel(s, t);
        return isOneDel(t, s);
    }

    public boolean isOneDel(String s, String t) {
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                return s.substring(i + 1).equals(t.substring(j));
            }
        }
        return true;
    }

    public boolean isOneModify(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diff++;
        }
        return diff == 1;
    }

    public boolean sln2(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                    return s.substring(i).equals(t.substring(i + 1));
                else // s is longer than t, so the only possibility is deleting one char from s
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }
}
