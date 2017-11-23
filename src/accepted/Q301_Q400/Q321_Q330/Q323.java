package accepted.Q301_Q400.Q321_Q330;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * 0          3
 * |          |
 * 1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * <p>
 * Example 2:
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * <p>
 * Note:
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class Q323 {

    public int countComponents(int n, int[][] edges) {

        int res = 0;
        Map<Integer, List<Integer>> m = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> remain = new HashSet<>();

        for (int i = 0; i < n; i++) {
            m.put(i, new ArrayList<>());
            remain.add(i);
        }

        for (int[] edge : edges) {
            m.get(edge[0]).add(edge[1]);
            m.get(edge[1]).add(edge[0]);
        }

        while (remain.size() > 0) {
            queue.addLast(remain.iterator().next());
            while (!queue.isEmpty()) {
                Integer key = queue.poll();
                remain.remove(key);
                List<Integer> list = m.get(key);
                for (Integer i : list) {
                    if (remain.contains(i)) {
                        remain.remove(i);
                        queue.addLast(i);
                    }
                }
            }
            res++;
        }

        return res;
    }

    @Test
    public void test() {
        int[][] a = {{0, 1}, {1, 2}, {0, 2}, {3, 4}};
        System.out.println(countComponents(5, a));
        int[][] b = {{0, 2}, {1, 2}};
        System.out.println(countComponents(3, b));
    }


    private int[] father;

    public int sln1(int n, int[][] edges) {

        Set<Integer> set = new HashSet<Integer>();
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }

        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    int find(int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father[node]);
        return father[node];
    }

    void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }

    public int sln2(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;

        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if (root1 != root2) {
                roots[root1] = root2;  // union
                n--;
            }
        }
        return n;
    }

    public int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }
}
