class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] changes = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2] == 1 ? 1 : -1;
            changes[start] += dir;
            changes[end + 1] -= dir;
        }

        // System.out.println(Arrays.toString(changes));   

        int[] finalChanges = new int[n];
        int shiftSum = 0;
        for (int i = 0; i < n; i++) {
            shiftSum += changes[i];
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
