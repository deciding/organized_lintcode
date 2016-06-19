import java.util.Arrays;
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public static int maxSubArray(int[] nums, int k) {
        // write your code here
    	int n=nums.length;
    	int[][] local= new int[k+1][n+1];
    	int[][] global= new int[k+1][n+1];
    	for(int i=1;i<=k;i++)
    		for(int j=1;j<=n;j++){
    			if(j<=i) {
                    // if we can have AT MOST k subarrays(elements), then no need this block
    	    		local[i][j]=local[i][j-1]+nums[j-1];// each subarray at leat 1 element!
    	    		global[i][j]=global[i][j-1]+nums[j-1];// each subarray at leat 1 element!
    			}
    			else{
	    			local[i][j]=Math.max(global[i-1][j-1]+nums[j-1], local[i][j-1]+nums[j-1]);//make sure i hops
	    			global[i][j]=Math.max(global[i][j-1], local[i][j]);// check whether updated the global
    			}
    		}
    	return global[k][n];
    }
    public static void main(String[] args){
    	System.out.println(maxSubArray(new int[]{-1,4,-2,3,-2,3},2));
    }
}