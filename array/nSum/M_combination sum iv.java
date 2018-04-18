public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        if(nums==null || nums.length==0)
        return 0;
 
        int[] dp = new int[target+1];
     
        dp[0]=1;
     
        for(int i=0; i<=target; i++){
           for(int num: nums){
               if(i+num<=target){
                   dp[i+num]+=dp[i];
               }
           }
        }
     
        return dp[target];
    }
}
