package accepted.Q601_Q700.Q641_Q650;

import java.util.List;

/**
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 * <p>
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 * <p>
 * You need to output the sentence after the replacement.
 * <p>
 * Example 1:
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Note:
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class Q648 {

    public String replaceWords(List<String> dict, String sentence) {

        Trie trie = new Trie();
        for (String s : dict) {
            trie.put(s);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String w : words) {
            w = trie.replace(w);
            sb.append(w).append(" ");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode(0);
    }

    void put(String s) {
        int i = 0;
        TrieNode curr = root;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (curr.nodes[c] == null) {
                curr.nodes[c] = new TrieNode(0);
            } else if (curr.nodes[c].val == 1) {
                break;
            }

            if (i == s.length() - 1) {
                curr.nodes[c].val = 1;
            }
            curr = curr.nodes[c];
            i++;
        }
    }

    String replace(String s) {
        int i = 0;
        TrieNode curr = root;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (curr.nodes[c] == null) {
                return s;
            } else if (curr.nodes[c].val == 1) {
                return s.substring(0, i + 1);
            }
            curr = curr.nodes[c];
            i++;
        }
        return s;
    }
}

class TrieNode {
    int val;
    TrieNode[] nodes;

    TrieNode(int val) {
        this.val = val;
        this.nodes = new TrieNode[256];
    }
}
