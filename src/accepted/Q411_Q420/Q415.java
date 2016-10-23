package accepted.Q411_Q420;

/**
 * Given two non-negative numbers num1 and num2 represented as string,
 * return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Q415 {

    public String addStrings(String num1, String num2) {

        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (idx1 >= 0 || idx2 >= 0) {
            int n1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int n2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;

            int sum = n1 + n2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.insert(0, sum);

            idx1--;
            idx2--;
        }

        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}
