class Solution {
    public int possibleStringCount(String word) {
        int possibilities = 1; 
        int n = word.length();
        int i = 0;

        while (i < n) {
            int count = 1;
            while (i + count < n && word.charAt(i) == word.charAt(i + count)) {
                count++;
            }

            if (count > 1) {
                possibilities += count - 1;
            }

            i += count;
        }

        return possibilities;
    }
}