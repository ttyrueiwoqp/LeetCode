package accepted.Q431_Q440;

/**
 * Count the number of segments in a string,
 * where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class Q434 {

    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        boolean isSpace = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (!isSpace) {
                    res++;
                }
                isSpace = true;
            } else {
                isSpace = false;
            }
        }
        if (!isSpace) {
            res++;
        }
        return res;
    }
}
