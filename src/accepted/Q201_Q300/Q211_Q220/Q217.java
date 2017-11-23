package accepted.Q201_Q300.Q211_Q220;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LU-PC on 5/28/2015.
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class Q217 {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        return numSet.size() != nums.length;
    }

}
