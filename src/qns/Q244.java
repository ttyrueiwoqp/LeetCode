package qns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * This is a follow up of Shortest Word Distance.
 * The only difference is now you are given the list of words and your method will be called
 * repeatedly many times with different parameters. How would you optimize it?
 * <p>
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and return the shortest distance
 * between these two words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * <p>
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * <p>
 * Show Company Tags
 * Show Tags
 * Show Similar Problems
 */
public class Q244 {

    public Q244(String[] words) {

    }

    public int shortest(String word1, String word2) {

        return 0;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");

class WordDistance {

    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            if(map.containsKey(w)) {
                map.get(w).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(w, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if(index1 < index2) {
                ret = Math.min(ret, index2 - index1);
                i++;
            } else {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;
    }
}