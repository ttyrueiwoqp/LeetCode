package accepted.Q401_Q500.Q461_Q470;

/**
 * In this problem, your job to write a function to check whether a input string is a valid IPv4 address or IPv6 address or neither.
 * <p>
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
 * each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * <p>
 * Besides, you need to keep in mind that leading zeros in the IPv4 is illegal.
 * For example, the address 172.16.254.01 is illegal.
 * <p>
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
 * The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a legal one.
 * Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
 * so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 * <p>
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity.
 * For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * <p>
 * Besides, you need to keep in mind that extra leading zeros in the IPv6 is also illegal.
 * For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is also illegal.
 * <p>
 * Note: You could assume there is no extra space in the test cases and there may some special characters in the input string.
 * <p>
 * Example 1:
 * Input: "172.16.254.1"
 * <p>
 * Output: "IPv4"
 * <p>
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * <p>
 * Output: "IPv6"
 * <p>
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * Input: "256.256.256.256"
 * <p>
 * Output: "Neither"
 * <p>
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
public class Q468 {

    public String validIPAddress(String IP) {
        if (validateIPv4(IP)) {
            return "IPv4";
        }
        if (validateIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean validateIPv4(String IP) {
        String[] strs = IP.split("\\.", -1);
        if (strs.length != 4) {
            return false;
        }

        for (String str : strs) {
            int len = str.length();
            if (len < 1 || len > 3 || (len > 1 && str.charAt(0) == '0')) {
                return false;
            }
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            if (Integer.parseInt(str) > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean validateIPv6(String IP) {
        String[] strs = IP.toLowerCase().split(":", -1);
        if (strs.length != 8) {
            return false;
        }

        for (String str : strs) {
            int len = str.length();
            if (len < 1 || len > 4) {
                return false;
            }
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c) && (c < 'a' || c > 'f')) {
                    return false;
                }
            }
        }

        return true;
    }
}
