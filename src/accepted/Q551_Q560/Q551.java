package accepted.Q551_Q560;

/**
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * <p>
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class Q551 {

    public boolean checkRecord(String s) {
        int absent = 0, late = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absent += 1;
                if (absent > 1) {
                    return false;
                }
            }

            if (c == 'L') {
                late += 1;
                if (late > 2) {
                    return false;
                }
            } else {
                late = 0;
            }
        }

        return true;
    }
}
