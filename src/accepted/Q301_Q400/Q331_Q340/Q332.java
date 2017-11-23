package accepted.Q301_Q400.Q331_Q340;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by FJ on 3/1/2016.
 * <p/>
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 * <p/>
 * Note:
 * If there are multiple valid itineraries,
 * you should return the itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * <p/>
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * <p/>
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 */
public class Q332 {

	public List<String> findItinerary(String[][] tickets) {

		List<String> res = new ArrayList<>();
		Map<String, PriorityQueue<String>> m = new HashMap<>();

		for (String[] ticket : tickets) {
			PriorityQueue<String> queue = m.get(ticket[0]);
			if (queue == null) {
				queue = new PriorityQueue<>();
				m.put(ticket[0], queue);
			}
			queue.add(ticket[1]);
		}

		Deque<String> stack = new ArrayDeque<>();
		stack.push("JFK");

		while (!stack.isEmpty()) {
			while (m.get(stack.peek()) != null && !m.get(stack.peek()).isEmpty()) {
				stack.push(m.get(stack.peek()).poll());
			}
			res.add(0, stack.pop());
		}

		return res;
	}

	@Test
	public void test() {
		String[][] t = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		String[][] t2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};

		System.out.println(findItinerary(t));
		System.out.println(findItinerary(t2));
	}
}
