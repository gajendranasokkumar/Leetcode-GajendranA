class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) 
            freq[c - 'a']++;
        int oddf = 0;
        int evenf = Integer.MAX_VALUE;
        for(int num : freq) {
            if(num % 2 == 0 && num != 0) 
                evenf = Math.min(evenf, num);
            else 
                oddf = Math.max(oddf, num);
        }
        return oddf - evenf;
    }
}