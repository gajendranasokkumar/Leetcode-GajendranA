class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int total = 0;
        int gain = 0;

        // prevZeros = size of the immediately preceding 0-group
        // (only valid if separated from current 0-group by exactly one 1-group)
        int prevZeros = -1;   // -1 means "no eligible previous zero group"
        int i = 0;

        while (i < n) {
            char c = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == c) 
                j++;
                
            int len = j - i;

            if (c == '1') {
                total += len;
                // a 1-group separates two 0-groups; keep prevZeros as-is
            } else { // c == '0'
                if (prevZeros >= 0) {
                    gain = Math.max(gain, prevZeros + len);
                }
                prevZeros = len;
            }
            i = j;
        }

        return total + gain;
    }
}