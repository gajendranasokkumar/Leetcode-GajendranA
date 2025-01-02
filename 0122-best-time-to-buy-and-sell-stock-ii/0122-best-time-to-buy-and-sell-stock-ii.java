class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int buy = 0;
        int sell = 0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[buy] > prices[i])
            {
                buy = i;
            }
            if(prices[buy] < prices[i])
            {
                totalProfit += prices[i] - prices[buy];
                buy = i;
            } 
        }

        return totalProfit;
    }
}