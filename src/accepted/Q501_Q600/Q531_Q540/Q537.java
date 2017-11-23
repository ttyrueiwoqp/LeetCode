package accepted.Q501_Q600.Q531_Q540;

/**
 * Given two strings representing two complex numbers.
 * <p>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p>
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * <p>
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the
 * range of [-100, 100]. And the output should be also in this form.
 */
public class Q537 {

    public String complexNumberMultiply(String a, String b) {
        String[] m = a.split("[+|i]");
        String[] n = b.split("[+|i]");

        Integer real = multiply(m[0], n[0]) - multiply(m[1], n[1]);
        Integer imaginary = multiply(m[0], n[1]) + multiply(m[1], n[0]);

        return real + "+" + imaginary + "i";
    }

    private Integer multiply(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }
}
