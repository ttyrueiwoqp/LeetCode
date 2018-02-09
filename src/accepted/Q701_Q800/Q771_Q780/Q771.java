package accepted.Q701_Q800.Q771_Q780;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class Q771 {

    public int numJewelsInStones(String J, String S) {
        int res = 0;
        int[] arr = new int[256];
        for (char cj : J.toCharArray()) {
            arr[cj] = 1;
        }
        for (char cs : S.toCharArray()) {
            if (arr[cs] == 1) {
                res++;
            }
        }
        return res;
    }
}
