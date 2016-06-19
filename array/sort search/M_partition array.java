package lintcode;
import java.util.*;
public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int p=0;
	    for(int i=0;i<nums.length;i++){
	        if(nums[i]<k) {
	            swap(nums,i,p);
	            p++;
	        }
	    }
	    return p;
    }
}