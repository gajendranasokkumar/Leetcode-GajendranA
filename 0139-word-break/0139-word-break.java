class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        return helper(s, s.length(), wordDict, new int[s.length()+1]);

    }

    // dp[i] will store the result of word break for each substring starting from position i 
    public boolean helper(String s, int n, List<String> wordDict, int[] dp) {
        // if we found word break for whole string, return true
        if (s.isEmpty()) return true;

        // if we have computed the result for given String s earlier  
        if (dp[n - s.length()] != 0) return dp[n - s.length()] == 1;

        // for each word in dictionary, check if it is prefix of given string
        for (String word : wordDict) {
            int l = word.length();
            
            // if word is prefix, then s will definitely be of lesser length than word's length
            if (s.length() >= l) {
                
                // if word is prefix of s, then break s and look for word break in remaining string
                if (s.startsWith(word)) {
                    boolean b = helper(s.substring(l), n, wordDict, dp);
                    
                    // if we found word break for remaining string, return true
                    if (b) {
                        dp[n - s.length()] = 1;
                        return b;
                    }
                }
            }
        }

        // if we didn't find word break for given string s, return false
        dp[n - s.length()] = -1;
        return false;

    }
}