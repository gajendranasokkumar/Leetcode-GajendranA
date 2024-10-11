class Solution {
    public int min(String word1,String word2,int i,int j,int dp[][]){
        
        if(j<0) return i+1;
        if(i<0) return j+1;

        char ch1 = word1.charAt(i);
        char ch2 = word2.charAt(j);

        if(dp[i][j]!=-1)    return dp[i][j];
        
        if(ch1==ch2){
            return dp[i][j] = min(word1,word2,i-1,j-1,dp);
        }
        else{
            int insert = 1+min(word1,word2,i,j-1,dp);
            int delete = 1+min(word1,word2,i-1,j,dp);
            int replace = 1+min(word1,word2,i-1,j-1,dp);
            return dp[i][j] = Math.min(insert,Math.min(delete,replace));
        }    
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return min(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
}
