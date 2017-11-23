package accepted.Q201_Q300.Q261_Q270;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * <p>
 * For example,
 * Given the following words in dictionary,
 * <p>
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * The correct order is: "wertf".
 * <p>
 * Note:
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class Q269 {

    public String alienOrder(String[] words) {

        StringBuilder res = new StringBuilder();
        if (words == null || words.length == 0) {
            return "";
        }

        Map<Character, Set<Character>> m = new HashMap<>();
        Map<Character, Integer> d = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (!m.containsKey(c)) {
                    m.put(c, new HashSet<>());
                    d.put(c, 0);
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            buildOrder(m, d, words[i - 1], words[i]);
        }

        Deque<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : d.entrySet()) {
            if (entry.getValue() == 0) {
                queue.addLast(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            res.append(c);
            for (Character t : m.get(c)) {
                d.put(t, d.get(t) - 1);
                if (d.get(t) == 0) {
                    queue.addLast(t);
                }
            }
        }

        return res.length() == m.entrySet().size() ? res.toString() : "";
    }

    private void buildOrder(Map<Character, Set<Character>> m, Map<Character, Integer> d, String w1, String w2) {
        int len = Math.min(w1.length(), w2.length());
        int i = 0;
        char[] c1 = w1.toCharArray();
        char[] c2 = w2.toCharArray();
        while (i < len) {
            if (c1[i] != c2[i]) {
                if (!m.get(c1[i]).contains(c2[i])) {
                    m.get(c1[i]).add(c2[i]);
                    d.put(c2[i], d.get(c2[i]) + 1);
                }
                return;
            }
            i++;
        }
    }

    @Test
    public void test() {
        String[] a = {"bsusz", "rhn", "gfbrwec", "kuw", "qvpxbexnhx", "gnp", "laxutz", "qzxccww"};
        System.out.println(alienOrder(a));
    }


    public String sln(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree = new HashMap<Character, Integer>();
        String result = "";
        if (words == null || words.length == 0) return result;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<Character>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<Character>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) q.add(c);
        }
        while (!q.isEmpty()) {
            char c = q.remove();
            result += c;
            if (map.containsKey(c)) {
                for (char c2 : map.get(c)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) q.add(c2);
                }
            }
        }
        if (result.length() != degree.size()) return "";
        return result;
    }
}
