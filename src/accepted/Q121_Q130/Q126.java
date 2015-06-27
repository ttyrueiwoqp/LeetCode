package accepted.Q121_Q130;

import org.junit.Test;

import java.util.*;

/**
 * Created by FJ on 6/27/2015.
 * <p/>
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * <p/>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * <p/>
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class Q126 {

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<>();

		List<ListNode> currs = new ArrayList<>();
		List<ListNode> ends = new ArrayList<>();
		ListNode sNode = new ListNode(start);
		currs.add(sNode);

		boolean isEndLevel = false;
		while (currs.size() > 0 && !isEndLevel) {
			List<ListNode> nexts = new ArrayList<>();
			Set<String> removeSet = new HashSet<>();

			for (ListNode node : currs) {
				Set<String> temp = new HashSet<>();
				char[] chars = node.val.toCharArray();

				boolean hasNext = false;
				for (int j = 0; j < node.val.length(); j++) {
					for (char k = 'a'; k <= 'z'; k++) {
						if (chars[j] == k) {
							continue;
						}
						char original = chars[j];
						chars[j] = k;
						String m = String.copyValueOf(chars);
						chars[j] = original;
						if (m.equals(end)) {
							isEndLevel = true;
							ListNode mNode = new ListNode(m);
							mNode.next = node;
							ends.add(mNode);

						} else if (dict.contains(m)) {
							removeSet.add(m);
							ListNode mNode = new ListNode(m);
							mNode.next = node;
							nexts.add(mNode);
						}
					}
				}
			}

			dict.removeAll(removeSet);
			currs = isEndLevel ? ends : nexts;
		}

		if (isEndLevel) {
			for (ListNode node : currs) {
				List<String> nodes = new ArrayList<>();
				while (node != null) {
					nodes.add(0, node.val);
					node = node.next;
				}
				res.add(nodes);
			}
		}

		return res;
	}

	private class ListNode {
		public String val;
		public ListNode next;

		public ListNode(String x) {
			val = x;
			next = null;
		}

		@Override
		public String toString() {
			return "[" + val + ", " + next + "]";
		}
	}

	@Test
	public void test() {
//		String[] a = {"hot", "dot", "dog", "lot", "log"};
//		List as = Arrays.asList(a);
//		Set<String> s = new HashSet<>(as);
//
//		System.out.println(findLadders("hit", "cog", s));
//
//		String[] a1 = {"a", "b", "c"};
//		List as1 = Arrays.asList(a1);
//		Set<String> s1 = new HashSet<>(as1);
//
//		System.out.println(findLadders("a", "c", s1));

		String[] a2 = {"ted","tex","red","tax","tad","den","rex","pee"};
		List as2 = Arrays.asList(a2);
		Set<String> s2 = new HashSet<>(as2);

		System.out.println(findLadders("red", "tax", s2));
	}
}
