package accepted.Q241_Q250;

import java.util.*;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 * We can keep "shifting" which forms the sequence:
 * <p>
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets,
 * group all strings that belong to the same shifting sequence.
 * <p>
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 * <p>
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 */
public class Q249 {

    public List<List<String>> groupStrings(String[] strings) {

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strings) {
            String key = buildKey(s);
            List<String> list = m.get(key);
            if (list == null) {
                list = new ArrayList<>();
                m.put(key, list);
            }
            list.add(s);
        }
        for (Map.Entry<String, List<String>> e : m.entrySet()) {
            List<String> list = e.getValue();
            Collections.sort(list);
            res.add(list);
        }

        return res;
    }

    private String buildKey(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int i = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char k = (char) (c - i);
            sb.append(k < 'a' ? k + 26 : k);
        }
        return sb.toString();
    }


    public List<List<String>> sln(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offList = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offList);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}
