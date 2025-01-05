class Solution {
    public String shiftingLetters(String s, int[] shift) {
        int n = s.length();
        int[] finalChanges = new int[n];
        int shiftSum = 0;
        for (int i = n-1; i >= 0; i--) {
            shiftSum += shift[i] % 26;
            finalChanges[i] = shiftSum;
        }

        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            int newChar = (s.charAt(i) - 'a' + finalChanges[i]) % 26;
            if (newChar < 0) 
                newChar += 26;
            str.setCharAt(i, (char) ('a' + newChar));
        }

        return str.toString();
    }
}
