class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int profit=0;
        for(int i=1;i<prices.length;i++)
        profit+=(prices[i]-prices[i-1]>0?prices[i]-prices[i-1]:0);
        return profit;
    }
};