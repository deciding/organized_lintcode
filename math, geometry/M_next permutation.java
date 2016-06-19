package lintcode;
import java.util.*;
//132->213
public class Solution {
    //swap and reverse !!
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public static int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums.length<2) return nums;
        int i,j=nums.length-1;
        for(i=nums.length-2;i>=0;i--)
        if(nums[i]<nums[i+1]){
            for(j=nums.length-1;j>i;j--)
            if(nums[i]<nums[j]) break;
            //swap !!
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            break;
        }
        //reverse !!
        for(int a=i+1;a<i+1+(nums.length-i-1)/2;a++){
            int tmp=nums[a];
            nums[a]=nums[nums.length-a+i];
            nums[nums.length-a+i]=tmp;
        }
        return nums;
    }
    public static void main(String[] args){
    	System.out.println(Arrays.toString(nextPermutation(new int[]{2,7,5,3,1})));
    }
}