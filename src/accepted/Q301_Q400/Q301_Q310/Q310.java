package accepted.Q301_Q400.Q301_Q310;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by FJ on 12/5/2015.
 * <p/>
 * For a undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees,
 * those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p/>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1.
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p/>
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p/>
 * Example 1:
 * <p/>
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p/>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * return [1]
 * <p/>
 * Example 2:
 * <p/>
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p/>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * return [3, 4]
 * <p/>
 * Hint:
 * <p/>
 * How many MHTs can a graph have at most?
 * Note:
 * <p/>
 * (1) According to the definition of tree on Wikipedia:
 * “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.”
 * <p/>
 * (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class Q310 {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		List<Integer> res = new ArrayList<>();
		if (n < 1) {
			return res;
		}
		if (n == 1) {
			res.add(0);
			return res;
		}

		Map<Integer, List<Integer>> m = new HashMap<>();
		for (int[] edge : edges) {
			List<Integer> a = m.get(edge[0]);
			if (a == null) {
				a = new ArrayList<>();
				m.put(edge[0], a);
			}
			a.add(edge[1]);

			List<Integer> b = m.get(edge[1]);
			if (b == null) {
				b = new ArrayList<>();
				m.put(edge[1], b);
			}
			b.add(edge[0]);
		}

		List<Integer> discard = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (m.get(i).size() == 1){
				discard.add(i);
			}
		}

		while (n > 2) {
			n -= discard.size();
			List<Integer> newDiscard = new ArrayList<>();
			for (Integer d : discard) {
				Integer i = m.get(d).get(0);
				m.get(i).remove(d);
				if (m.get(i).size() == 1) {
					newDiscard.add(i);
				}
			}
			discard = newDiscard;
		}

		return discard;
	}

	public List<Integer> findMinHeightTrees2(int n, int[][] edges) {

		List<Integer> res = new ArrayList<>();
		if (edges.length == 0) {
			return res;
		}

		Map<Integer, List<Integer>> m = new HashMap<>();

		for (int[] edge : edges) {
			List<Integer> a = m.get(edge[0]);
			if (a == null) {
				a = new ArrayList<>();
				m.put(edge[0], a);
			}
			a.add(edge[1]);

			List<Integer> b = m.get(edge[1]);
			if (b == null) {
				b = new ArrayList<>();
				m.put(edge[1], b);
			}
			b.add(edge[0]);
		}

		int min = Integer.MAX_VALUE;
		Set<Integer> visited = new HashSet<>();
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			int h = m.get(i).size() == 1 ? 1 : findHeight(m, visited, i, 0);
			heights[i] = h;
			min = Math.min(min, h);
			visited.clear();
		}

		for (int i = 0; i < n; i++) {
			if (heights[i] == min) {
				res.add(i);
			}
		}

		return res;
	}

	private int findHeight(Map<Integer, List<Integer>> m, Set<Integer> visited, Integer i, int h) {
		boolean allVisited = true;
		int max = 0;
		visited.add(i);
		for (Integer j : m.get(i)) {
			if (!visited.contains(j)) {
				allVisited = false;
				int height = findHeight(m, visited, j, h + 1);
				max = Math.max(max, height);
			}
		}
		if (allVisited) {
			return 0;
		}
		return max;
	}

	@Test
	public void test() {
		int[][] a = {{1,0}, {1,2}, {1,3}};
		System.out.println(findMinHeightTrees(4, a));
		int[][] b = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		System.out.println(findMinHeightTrees(6, b));
	}
}
