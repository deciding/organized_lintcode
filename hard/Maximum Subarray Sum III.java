public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
    	int n=nums.length;
    	int[][] local= new int[k+1][n+1];
    	int[][] global= new int[k+1][n+1];
    	for(int i=1;i<=k;i++)
    		for(int j=1;j<=n;j++){
    			if(j<=i) {
    	    		local[i][j]=local[i][j-1]+nums[j-1];
    	    		global[i][j]=global[i][j-1]+nums[j-1];
    			}
    			else{
	    			local[i][j]=Math.max(global[i-1][j-1]+nums[j-1], local[i][j-1]+nums[j-1]);
	    			global[i][j]=Math.max(global[i][j-1], local[i][j]);
    			}
    		}
    	return global[k][n];
    }
}
