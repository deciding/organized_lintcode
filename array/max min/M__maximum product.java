package lintcode;
import java.util.*;
//正负问题 留一颗后悔药
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    // key !! pos neg, so use max min
    public int maxProduct(int[] nums) {
        // write your code here
    	if(nums==null||nums.length==0) return 0;
    	if(nums.length==1) return nums[0];
        int[] max= new int[nums.length];
        int[] min= new int[nums.length];
        int ans=0;
        max[0]=nums[0];
        min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            // key !! same as subarray max sum, but also need consider both neg and pos
        	max[i]=(Math.max(nums[i], Math.max(max[i-1]*nums[i],min[i-1]*nums[i])));
        	min[i]=(Math.min(nums[i], Math.min(max[i-1]*nums[i],min[i-1]*nums[i])));
        	ans=Math.max(ans, max[i]);
        }
        return ans;
    }
}