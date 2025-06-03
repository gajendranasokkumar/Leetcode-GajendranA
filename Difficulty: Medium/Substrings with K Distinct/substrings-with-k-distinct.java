// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        return countSubstrr(s, k);
        
    }
    
    static int count(String s, int k) {
        int n = s.length();
        int ans = 0;

        // Use sliding window technique
        int[] freq = new int[26];
        int distinctCnt = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {

            // Expand window and add character
            freq[s.charAt(j) - 'a']++;
            if (freq[s.charAt(j) - 'a'] == 1) distinctCnt++;

            // Shrink window if distinct characters exceed k
            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;
                if (freq[s.charAt(i) - 'a'] == 0) distinctCnt--;
                i++;
            }

            // Add number of valid substrings ending at j
            ans += j - i + 1;
        }

        return ans;
    }

    // Function to find the number of substrings
    // with exactly k Distinct characters.
    static int countSubstrr(String s, int k) {
        int n = s.length();
        int ans = 0;

        // Subtract substrings with at most 
        // k-1 distinct characters from substrings
        // with at most k distinct characters
        ans = count(s, k) - count(s, k - 1);

        return ans;
    }
}