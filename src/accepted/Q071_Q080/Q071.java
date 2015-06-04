package accepted.Q071_Q080;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by LU-PC on 6/3/2015.
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Q071 {
	public String simplifyPath(String path) {
		Deque<String> deque = new ArrayDeque<>();
		String[] parts = path.split("/");

		for (String s : parts) {
			switch (s) {
				case "":
				case ".":
					break;
				case "..":
					if (!deque.isEmpty()) {
						deque.pop();
					}
					break;
				default:
					deque.push(s);
					break;
			}
		}

		StringBuilder res = new StringBuilder();
		while (!deque.isEmpty()) {
			res.append("/").append(deque.pollLast());
		}
		if (res.length() == 0) {
			res.append("/");
		}
		return res.toString();
	}

	@Test
	public void test() {
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/home//foo/"));
		System.out.println(simplifyPath("/../"));
	}
}
