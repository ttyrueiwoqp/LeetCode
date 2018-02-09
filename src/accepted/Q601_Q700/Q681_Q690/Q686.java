package accepted.Q601_Q700.Q681_Q690;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class Q686 {

    public int repeatedStringMatch(String A, String B) {

        int k = 0;
        while (k < A.length()) {

            int i = k, j = 0, count = 1;
            while (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
                if (j == B.length()) {
                    return count;
                }
                if (i == A.length()) {
                    i = 0;
                    count++;
                }
            }

            k++;
        }

        return -1;
    }
}
