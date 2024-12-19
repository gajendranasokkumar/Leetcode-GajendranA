class Solution {
    int[][] memo; 

    int min(int[] coins, int index, int target) {
        if (target == 0) return 1;

        if (index < 0 || target < 0) return 0;

       if (memo[index][target] != -1) return memo[index][target];

        int exclude = min(coins, index - 1, target);
        int include = min(coins, index, target - coins[index]);

        memo[index][target] = exclude + include;
        return memo[index][target];
    }

    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for(int[] i: memo)
            Arrays.fill(i, -1);

        return min(coins, coins.length - 1, amount);
    }
}



// class Solution {
//      public static int minimum(int i,int target,int arr[],int dp[][]){
//         if(i==0){
//             if(target%arr[i]==0)
//                 return target/arr[i];
//             else
//                 return (int)Math.pow(10,9);
//         }
//         if(target==0)
//             return 0;
//         if(dp[i][target]!=-1)
//             return dp[i][target];
//         int take = Integer.MAX_VALUE;
//         int nottake =0+ minimum(i-1,target,arr,dp);
//         if(arr[i]<=target)
//             take = 1+ minimum(i,target-arr[i],arr,dp);
//         return dp[i][target] = Math.min(take,nottake);        
//     }
//     public static int coinChange(int num[], int x) {
//         int [][] dp = new int[num.length][x+1];
//         for(int i[] : dp)
//             Arrays.fill(i,-1);
//         int res = minimum(num.length-1,x,num,dp);
//         if (res >= (int) Math.pow(10, 9))
//             return -1;
//         return res;
//     }
// }