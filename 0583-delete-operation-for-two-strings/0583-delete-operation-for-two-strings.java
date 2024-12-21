class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] i : dp)
            Arrays.fill(i, -1);

        return min(word1, word2, 0, 0, dp);
    }
    public int min(String s1, String s2, int i, int j, int[][] dp) {
        if(i >= s1.length())
            return dp[i][j] = (j <= s2.length()) ? s2.length() - j : 0;
        else if(j >= s2.length()) 
                return dp[i][j] = (i <= s1.length()) ? s1.length() - i : 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = min(s1, s2, i+1, j+1, dp);
        
        int l = min(s1, s2, i+1, j, dp);
        int r = min(s1, s2, i, j+1, dp);

        return dp[i][j] = 1 + Math.min(l, r);
    }
}
/// ****** IMPORTANT ********* ///
// return (word1.size()+word2.size())-2*lcs(word1,word2))