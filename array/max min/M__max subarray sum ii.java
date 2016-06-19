package lintcode;
import java.util.*;
//O(N) time, O(N) space, exclusive subarrays, record left and right !!
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code here
    	if(nums.size()<2) return Integer.MIN_VALUE;
        int ans=nums.get(0)+nums.get(1);
    	int[] leftMax=new int[nums.size()];
    	int[] rightMax=new int[nums.size()];
    	int max;//max min sum end at this pos
        //key blocks !!
        // another way to record subarray max sum
    	max=leftMax[0]=nums.get(0);
    	for(int i=1;i<nums.size();i++){
    		  max=Math.max(nums.get(i),nums.get(i)+max);
    		  leftMax[i]=Math.max(leftMax[i-1], max);
    	}
    	max=rightMax[nums.size()-1]=nums.get(nums.size()-1);
    	for(int i=nums.size()-2;i>=0;i--){
  		  max=Math.max(nums.get(i),nums.get(i)+max);
  		  rightMax[i]=Math.max(rightMax[i+1], max);
    	}
    	for(int i=0;i<nums.size()-1;i++)
    		ans=Math.max(ans, leftMax[i]+rightMax[i+1]);
    	return ans;
    }
}