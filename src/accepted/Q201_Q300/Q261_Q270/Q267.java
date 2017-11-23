package accepted.Q201_Q300.Q261_Q270;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 * <p>
 * For example:
 * <p>
 * Given s = "aabb", return ["abba", "baab"].
 * <p>
 * Given s = "abc", return [].
 * <p>
 * Hint:
 * <p>
 * If a palindromic permutation exists, we just need to generate the first half of the string.
 * To generate all distinct permutations of a (half of) string, use a similar approach from:
 * Permutations II or Next Permutation.
 */
public class Q267 {

    public List<String> generatePalindromes(String s) {

        StringBuilder mid = new StringBuilder();
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        Set<String> res = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                list.add(c);
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if (set.size() > 1) {
            return new ArrayList<>(res);
        } else if (set.size() == 1) {
            mid.append(set.iterator().next());
        }

        List<String> perms = getPermutations(list);
        for (String perm : perms) {
            res.add(perm + mid + new StringBuilder(perm).reverse().toString());
        }

        return new ArrayList<>(res);
    }

    private List<String> getPermutations(List<Character> cs) {
        List<String> res = new ArrayList<>();
        helper(cs, res, new StringBuilder(), new boolean[cs.size()]);
        return res;
    }

    private void helper(List<Character> cs, List<String> res, StringBuilder sb, boolean[] used) {
        if (sb.length() == cs.size()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < cs.size(); i++) {
            if (used[i]) {
                continue;
            }

            sb.append(cs.get(i));
            used[i] = true;

            helper(cs, res, sb, used);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    @Test
    public void test() {
        System.out.println(generatePalindromes("aabb"));
    }


















    public List<String> sln(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        // cannot form any palindromic string
        if (odd > 1) return res;

        // step 2. add half count of each character to list
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) mid += key;

            for (int i = 0; i < val / 2; i++) list.add(key);
        }

        // step 3. generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);

        return res;
    }

    // generate all unique permutation from list
    void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

            if (!used[i]) {
                used[i] = true; sb.append(list.get(i));
                // recursion
                getPerm(list, mid, used, sb, res);
                // backtracking
                used[i] = false; sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
