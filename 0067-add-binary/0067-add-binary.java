import java.util.*;

class Solution {

    public List<Character> addTwo(char one, char two) {
        char carry = '0', sum = '0';
        if (one == '1') {
            if (two == '1') {
                sum = '0';
                carry = '1';
            } else {
                sum = '1';
            }
        } else {
            if (two == '1') {
                sum = '1';
            }
        }

        return Arrays.asList(sum, carry);
    }

    public String addBinary(String a, String b) {
        String longs = (a.length() > b.length() ? a : b);
        String shorts = (a.length() <= b.length() ? a : b);

        char carry = '0';
        StringBuilder result = new StringBuilder();
        int longPointer = longs.length() - 1;
        int shortPointer = shorts.length() - 1;

        while (longPointer >= 0 || shortPointer >= 0 || carry == '1') {
            char longChar = longPointer >= 0 ? longs.charAt(longPointer) : '0';
            char shortChar = shortPointer >= 0 ? shorts.charAt(shortPointer) : '0';

            List<Character> sumAndCarry = addTwo(longChar, shortChar);
            char sum = sumAndCarry.get(0);
            char newCarry = sumAndCarry.get(1);

            if (carry == '1') {
                List<Character> carryResult = addTwo(sum, carry);
                sum = carryResult.get(0);
                newCarry = carryResult.get(1) == '1' ? '1' : newCarry;
            }

            result.append(sum);
            carry = newCarry;

            longPointer--;
            shortPointer--;
        }

        return result.reverse().toString();
    }
}
