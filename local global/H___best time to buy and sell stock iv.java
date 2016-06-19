import java.util.*;
//DP which uses 2 memos !!
// !! We use local to see whether each local(sell at this day) will update global (similar to find max in a array, max is global
//A[i] is local); for local, 2 cases, buy today, or accumulate from yesterday. accumulate from yesterday is the key logic !!
//actually keep 2 rows of mem is enough, each row means we already transacts at most r times.
class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public static int maxProfit(int k, int[] prices) {
        // write your code here
    	if(k==0||prices==null||prices.length<=1) return 0;
    	int maxPrftCnt=0,maxPrft=0;
    	for(int i=1;i<prices.length;i++)
    		if(prices[i]-prices[i-1]>0){
    			maxPrft+=prices[i]-prices[i-1];
    			maxPrftCnt++;
    		}
    	if(maxPrftCnt<=k) return maxPrft;
    	//size: bcoz global[i-1][j-1]
    	int[][] local= new int[k+1][prices.length+1];//best- sell at jth day, with i transactions
    	int[][] global= new int[k+1][prices.length+1];// best- sell at 1-jth day, with i transactions
    	for(int i=1;i<k+1;i++)
    		for(int j=2;j<prices.length+1;j++){
    			//Math.max(buy and sell at jth day, only sell at jth day), the second one is the key relationship
    			local[i][j]=Math.max(global[i-1][j-1], local[i][j-1]+prices[j-1]-prices[j-2]);
    			//Math.max(not sell at jth day, sell at jth day);
    			global[i][j]=Math.max(global[i][j-1], local[i][j]);
    		}
    	return global[k][prices.length];
    }
    public static void main(String[] args){
    	System.out.println(maxProfit(2,new int[]{4,4,6,1,1,4,2,5}));
    }
};