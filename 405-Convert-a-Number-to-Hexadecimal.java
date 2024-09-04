public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return \0\;
        }

        char[] hexChars = \0123456789abcdef\.toCharArray();
        StringBuilder hexString = new StringBuilder();

        // Handle two's complement for negative numbers
        while (num != 0 && hexString.length() < 8) { // At most 8 hex digits for a 32-bit number
            int remainder = num & 0xF; // Get the last 4 bits
            hexString.append(hexChars[remainder]);
            num >>>= 4; // Unsigned right shift by 4 bits
        }

        return hexString.reverse().toString();
    }
}
