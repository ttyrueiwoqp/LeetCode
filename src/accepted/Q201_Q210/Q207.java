package accepted.Q201_Q210;

import org.junit.Test;

import java.util.*;

/**
 * Created by LU-PC on 7/3/2015.
 * <p/>
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p/>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p/>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p/>
 * For example:
 * <p/>
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * <p/>
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1. So it is impossible.
 * <p/>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * <p/>
 * click to show more hints.
 * <p/>
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 */
public class Q207 {

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> m = new HashMap<>();
		int[] explored = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			List<Integer> prereqs = m.get(prerequisites[i][0]);
			if (prereqs == null) {
				prereqs = new ArrayList<>();
			}
			prereqs.add(prerequisites[i][1]);
			m.put(prerequisites[i][0], prereqs);
		}

		return !hasCycle(m, explored);
	}

	private boolean hasCycle(Map<Integer, List<Integer>> m, int[] explored) {
		for (Integer course : m.keySet()) {
			if (hasCycle(m, course, explored)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasCycle(Map<Integer, List<Integer>> m, Integer course, int[] explored) {

		if (explored[course] == -1) {
			return false;
		}
		explored[course] = 1;

		List<Integer> prereqs = m.get(course);
		if (prereqs == null) {
			explored[course] = -1;
			return false;
		}

		for (Integer prereq : prereqs) {
			if (explored[prereq] == 1 || hasCycle(m, prereq, explored)) {
				return true;
			}
		}

		explored[course] = -1;
		return false;
	}

	@Test
	public void test() {

		int numCourses = 4;
		int[][] prerequisites1 = {{0, 1}, {3, 1}, {1, 3}, {3, 2}};
		int[][] prerequisites2 = {{1, 0}, {2, 0}};
		int[][] prerequisites3 = {{0, 1}, {0, 2}, {1, 2}};
		System.out.println(canFinish(numCourses, prerequisites1));
		System.out.println(canFinish(numCourses, prerequisites2));
		System.out.println(canFinish(numCourses, prerequisites3));

	}
}
