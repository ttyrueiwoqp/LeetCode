package qns;

import java.util.HashMap;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Below are some examples of word abbreviations:
 * <p>
 * a) it                      --> it    (no abbreviation)
 * <p>
 * 1
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 */
public class Q288 {

    public Q288(String[] dictionary) {

    }

    public boolean isUnique(String word) {

        return false;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");

class ValidWordAbbr {
    HashMap<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for (String str : dictionary) {
            String key = getKey(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if (map.containsKey(key)) {
                if (!map.get(key).equals(str)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }

    String getKey(String str) {
        if (str.length() <= 2) return str;
        return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
    }
}