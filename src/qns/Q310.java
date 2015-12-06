package qns;

import java.util.List;

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
 * (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 * <p/>
 * (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class Q310 {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {


		return null;
	}
}
