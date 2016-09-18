package accepted.Q390_Q400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above:
 * <p>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero
 * and there is no contradiction.
 */
public class Q399 {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> m = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String[] s = equations[i];
            double val = values[i];

            Map<String, Double> m0 = m.get(s[0]);
            if (m0 == null) {
                m0 = new HashMap<>();
                m.put(s[0], m0);
            }
            m0.put(s[1], val);

            Map<String, Double> m1 = m.get(s[1]);
            if (m1 == null) {
                m1 = new HashMap<>();
                m.put(s[1], m1);
            }
            m1.put(s[0], 1 / val);
        }

        double[] res = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            res[i] = dfs(m, new HashSet<>(), queries[i][0], queries[i][1]);
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> m, Set<String> visited, String src, String dest) {

        if (!m.containsKey(src)) {
            return -1.0d;
        }

        for (Map.Entry<String, Double> e : m.get(src).entrySet()) {
            if (e.getKey().equals(dest)) {
                return e.getValue();
            }

            if (visited.contains(e.getKey())) {
                continue;
            }
            visited.add(e.getKey());
            double val = dfs(m, visited, e.getKey(), dest);
            visited.remove(e.getKey());

            if (val != -1.0d) {
                return val * e.getValue();
            }

        }

        return -1.0d;
    }
}
