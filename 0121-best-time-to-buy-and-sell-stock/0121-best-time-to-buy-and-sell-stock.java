class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int min = prices[0];
        int sell = 0;
        for(int i=1;i<prices.length;i++)
        {
            if(min > prices[i])
                min = prices[i];
            else if(prices[i] - min > maxProfit)
            {
                maxProfit = prices[i] - min;
                sell = i;
            }
        }

        return (maxProfit == Integer.MIN_VALUE) ? 0 : maxProfit;
    }
}