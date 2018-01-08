package accepted.Q701_Q800.Q731_Q740;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q734 {

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> m = new HashMap<>();
        for (String[] pair : pairs) {
            Set<String> set1 = m.computeIfAbsent(pair[0], k -> new HashSet<>());
            set1.add(pair[1]);

            Set<String> set2 = m.computeIfAbsent(pair[1], k -> new HashSet<>());
            set2.add(pair[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])
                    && !(m.containsKey(words1[i]) && m.get(words1[i]).contains(words2[i]))) {
                return false;
            }
        }

        return true;
    }
}
