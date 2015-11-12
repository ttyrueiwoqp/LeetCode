package accepted.Q201_Q210;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by FJ on 11/12/2015.
 * <p/>
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p/>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * <p/>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses
 * you should take to finish all courses.
 * <p/>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to
 * finish all courses, return an empty array.
 * <p/>
 * For example:
 * <p/>
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0.
 * So the correct course order is [0,1]
 * <p/>
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
 * Another correct ordering is[0,2,1,3].
 * <p/>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * <p/>
 * click to show more hints.
 * <p/>
 * Hints:
 * This problem is equivalent to finding the topological order in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 */
public class Q210 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		int[] result = new int[numCourses];

		List<Integer> res = new ArrayList<>();
		Map<Integer, List<Integer>> m = new HashMap<>();
		int[] explored = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			m.put(i, new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			List<Integer> prereqs = m.get(prerequisites[i][0]);
			prereqs.add(prerequisites[i][1]);
			m.put(prerequisites[i][0], prereqs);
		}

		for (Integer course : m.keySet()) {
			if (hasCycle(m, course, explored, res)) {
				return new int[0];
			}
		}

		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}

		return result;
	}

	private boolean hasCycle(Map<Integer, List<Integer>> m, Integer course, int[] explored, List<Integer> res) {

		if (explored[course] == -1) {
			return false;
		}
		explored[course] = 1;

		List<Integer> prereqs = m.get(course);
		for (Integer prereq : prereqs) {
			if (explored[prereq] == 1 || hasCycle(m, prereq, explored, res)) {
				return true;
			}
		}

		explored[course] = -1;
		res.add(course);
		return false;
	}

	@Test
	public void test() {

		int numCourses = 4;
		int[][] prerequisites1 = {{0, 1}, {3, 1}, {1, 3}, {3, 2}};
		int[][] prerequisites2 = {{1, 0}, {2, 0}};
		int[][] prerequisites3 = {{0, 1}, {0, 2}, {1, 2}};
		int[][] prerequisites4 = {{}};

		print(findOrder(numCourses, prerequisites1));
		print(findOrder(3, prerequisites2));
		print(findOrder(3, prerequisites3));
		print(findOrder(3, prerequisites4));

	}

	private void print(int[] order) {
		for (int i = 0; i < order.length; i++) {
			System.out.print(order[i] + " ");
		}
		System.out.println();
	}
}
