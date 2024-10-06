class Solution {
     public static int minimum(int i,int target,int arr[],int dp[][]){
        if(i==0){
            if(target%arr[i]==0)
                return target/arr[i];
            else
                return (int)Math.pow(10,9);
        }
        if(target==0)
            return 0;
        if(dp[i][target]!=-1)
            return dp[i][target];
        int take = Integer.MAX_VALUE;
        int nottake =0+ minimum(i-1,target,arr,dp);
        if(arr[i]<=target)
            take = 1+ minimum(i,target-arr[i],arr,dp);
        return dp[i][target] = Math.min(take,nottake);        
    }
    public static int coinChange(int num[], int x) {
        int [][] dp = new int[num.length][x+1];
        for(int i[] : dp)
            Arrays.fill(i,-1);
        int res = minimum(num.length-1,x,num,dp);
        if (res >= (int) Math.pow(10, 9))
            return -1;
        return res;
    }
}