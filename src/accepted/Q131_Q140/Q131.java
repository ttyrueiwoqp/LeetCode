package accepted.Q131_Q140;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Q131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        if (s.length() < 2) {
            List<String> self = new ArrayList<>();
            if (!s.isEmpty()) {
                self.add(s);
            }
            res.add(self);
            return res;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            String second = s.substring(i);
            if (isPalindrome(second)) {
                List<List<String>> firsts = partition(s.substring(0, i));
                for (List<String> first : firsts) {
                    first.add(second);
                    res.add(first);
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (s.charAt(i) == s.charAt(j) && i < j) {
            i++;
            j--;
        }
        return i >= j;
    }


    public List<List<String>> partition2(String s) {

        List<List<Integer>> info = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            info.add(new ArrayList<>());

            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    info.get(i).add(j);
                }
            }
        }

        return process(info, 0, s);
    }

    private List<List<String>> process(List<List<Integer>> info, int i, String s) {
        List<List<String>> res = new ArrayList<>();

        if (i >= s.length()) {
            res.add(new ArrayList<>());
            return res;
        }

        List<Integer> js = info.get(i);
        for (Integer j : js) {
            List<List<String>> nexts = process(info, j + 1, s);
            for (List<String> next : nexts) {
                next.add(0, s.substring(i, j + 1));
                res.add(next);
            }
        }

        return res;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
