package lintcode;
import java.util.*;
// similar to M__max subarray sum ii
//O(N) time, O(N) space, exclusive subarrays, record left and right !!
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
    	int ans=0;
    	if(nums.length==0) return Integer.MIN_VALUE;
    	int[] leftMax=new int[nums.length];
    	int[] leftMin=new int[nums.length];
    	int[] rightMax=new int[nums.length];
    	int[] rightMin=new int[nums.length];
    	int max,min;//max min sum end at this pos
    	max=min=leftMax[0]=leftMin[0]=nums[0];
    	for(int i=1;i<nums.length;i++){
    		  max=Math.max(nums[i],nums[i]+max);
    		  leftMax[i]=Math.max(leftMax[i-1], max);
    		  min=Math.min(nums[i],nums[i]+min);
    		  leftMin[i]=Math.min(leftMin[i-1], min);
    	}
    	max=min=rightMax[nums.length-1]=rightMin[nums.length-1]=nums[nums.length-1];
    	for(int i=nums.length-2;i>=0;i--){
  		  max=Math.max(nums[i],nums[i]+max);
  		  rightMax[i]=Math.max(rightMax[i+1], max);
  		  min=Math.min(nums[i],nums[i]+min);
  		  rightMin[i]=Math.min(rightMin[i+1], min);
    	}
    	for(int i=0;i<nums.length-1;i++)
    		ans=Math.max(ans, Math.max(leftMax[i]-rightMin[i+1], rightMax[i+1]-leftMin[i]));
    	return ans;
    }
}

