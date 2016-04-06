package qns;

import java.util.*;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).
 * <p>
 * Write a function to count the total strobogrammatic numbers that exist in the range
 * of low <= num <= high.
 * <p>
 * For example,
 * Given low = "50", high = "100", return 3. Because 69, 88, and 96
 * are three strobogrammatic numbers.
 * <p>
 * Note:
 * Because the range might be a large number,
 * the low and high numbers are represented as string.
 */
public class Q248 {

    private Map<Integer, List<String>> map = new HashMap<>();

    public int strobogrammaticInRange(String low, String high) {

        findStrobogrammatic(high.length(), high.length());
        findStrobogrammatic(low.length(), low.length());

        return 0;
    }

    private void findStrobogrammatic(int n, int m) {

        if (map.containsKey(n)) {
            return;
        }

        List<String> res = new ArrayList<>();
        if (n < 1) {
            res.add("");
            map.put(n, res);
            return;

        } else if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            map.put(n, res);
            return;

        } else {
            findStrobogrammatic(n - 2, m);
            List<String> n2 = map.get(n - 2);
            for (String s : n2) {
                res.add("0" + s + "0");
                res.add("1" + s + "1");
                res.add("6" + s + "9");
                res.add("8" + s + "8");
                res.add("9" + s + "6");
            }
        }

        map.put(n, res);
    }
























    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    int count = 0;

    public int sln(String low, String high) {
        for(int len = low.length(); len <= high.length(); len++) {
            dfs(low, high, new char[len], 0, len - 1);
        }
        return count;
    }

    public void dfs(String low, String high, char[] c, int left, int right) {
        if(left > right) {
            String s = new String(c);
            if((s.length() == low.length() && s.compareTo(low) < 0) ||
                    (s.length() == high.length() && s.compareTo(high) > 0)) return;
            count++;
            return;
        }

        for(char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if(c.length != 1 && c[0] == '0') continue;
            if(left < right || left == right && p[0] == p[1]) dfs(low, high, c, left + 1, right - 1);
        }
    }

    public int sln2(String low, String high){
        int count = 0;
        List<String> rst = new ArrayList<String>();
        for(int n = low.length(); n <= high.length(); n++){
            rst.addAll(helper(n, n));
        }
        for(String num : rst){

            if((num.length() == low.length()&&num.compareTo(low) < 0 ) ||(num.length() == high.length() && num.compareTo(high) > 0)) continue;
            count++;
        }
        return count;
    }

    private List<String> helper(int cur, int max){
        if(cur == 0) return new ArrayList<String>(Arrays.asList(""));
        if(cur == 1) return new ArrayList<String>(Arrays.asList("1", "8", "0"));

        List<String> rst = new ArrayList<String>();
        List<String> center = helper(cur - 2, max);

        for(int i = 0; i < center.size(); i++){
            String tmp = center.get(i);
            if(cur != max) rst.add("0" + tmp + "0");
            rst.add("1" + tmp + "1");
            rst.add("6" + tmp + "9");
            rst.add("8" + tmp + "8");
            rst.add("9" + tmp + "6");
        }
        return rst;
    }
}
