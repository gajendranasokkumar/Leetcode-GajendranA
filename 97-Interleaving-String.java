class Solution {
    public boolean fun(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp) {
        if(k == s3.length() && i == s1.length() && j == s2.length())
            return true;
        
        if (dp[i][j] != null) 
            return dp[i][j];
        
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            if(fun(s1, s2, s3, i+1, j, k+1, dp))
                return dp[i][j] = true;
        }  
        
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if(fun(s1, s2, s3, i, j+1, k+1, dp))
                return dp[i][j] = true;
        }

        return dp[i][j] = false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len1 + len2 != len3) 
            return false;
        
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];

        return fun(s1, s2, s3, 0, 0, 0, dp);
    }
}   