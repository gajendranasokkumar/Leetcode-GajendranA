class Solution {
    int countStrings(String s) {
        int[] freq = new int[26];
        int total = s.length();
        for(char c : s.toCharArray()) 
            freq[c - 'a']++;
        int res = 0;
        boolean isThere = false;
        for(int num : freq) {
            if(num > 1)
                isThere = true;
            if(num != 0) {
                total -= num;
                res += num * total;
            }
        }
        return res + (isThere ? 1 : 0);
    }
}