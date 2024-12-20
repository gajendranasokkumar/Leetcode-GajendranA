class Solution {
    public int longest(String s,int start,int end,int dp[][]){
        if(start>end) return 0;
        char ch1 = s.charAt(start);
        char ch2 = s.charAt(end);
        if(start==end) 
            return 1;
            
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        if(ch1==ch2)
            return dp[start][end] = 2+longest(s,start+1,end-1,dp);
        else{
            int l = longest(s,start,end-1,dp);
            int r = longest(s,start+1,end,dp);
            return dp[start][end] = Math.max(l,r);
        }
    }
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return longest(s,0,s.length()-1,dp);
    }
}