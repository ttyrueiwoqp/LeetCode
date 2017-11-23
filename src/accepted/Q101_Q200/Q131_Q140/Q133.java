package accepted.Q101_Q200.Q131_Q140;

import org.junit.Test;
import util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FJ on 11/1/2015.
 * <p/>
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * <p/>
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * <p/>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p/>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p/>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * <p/>
 * 1
 * / \
 * /   \
 * 0 --- 2
 * / \
 * \_/
 */


public class Q133 {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null) {
			return null;
		}

		Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		visited.put(node, newNode);

		addNeighbors(node, newNode, visited);

		return newNode;
	}

	private void addNeighbors(UndirectedGraphNode node,
	                              UndirectedGraphNode newNode,
	                              Map<UndirectedGraphNode, UndirectedGraphNode> visited) {

		for (UndirectedGraphNode neighbor : node.neighbors) {
			UndirectedGraphNode newNeighbor = visited.get(neighbor);
			if (newNeighbor == null) {
				newNeighbor = new UndirectedGraphNode(neighbor.label);
				visited.put(neighbor, newNeighbor);
				addNeighbors(neighbor, newNeighbor, visited);
			}
			newNode.neighbors.add(newNeighbor);
		}
	}

	@Test
	public void test() {

		UndirectedGraphNode[] n = new UndirectedGraphNode[3];
		for (int i = 0; i < n.length; i++) {
			n[i] = new UndirectedGraphNode(i);
		}
		n[0].neighbors.add(n[1]);
		n[0].neighbors.add(n[2]);
		n[1].neighbors.add(n[0]);
		n[1].neighbors.add(n[2]);
		n[2].neighbors.add(n[0]);
		n[2].neighbors.add(n[1]);
		n[2].neighbors.add(n[2]);

		UndirectedGraphNode n1 = cloneGraph(n[0]);
		System.out.println(n1.label);
	}
}
