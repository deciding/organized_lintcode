package lintcode;
import java.util.*;
//two pointers !!
//method O(NlogN) test 1-N length using binary search,
//for x in range(len(nums)):
//sums += nums[x]
//if x >= l:
//  sums -= nums[x - l]
//if sums >= s:
//  return True
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int a=0,b=0;
        int sum=0,min=Integer.MAX_VALUE;
        while(b<nums.length){
            sum+=nums[b];
            while(sum>=s){
                min=Math.min(min,b-a+1);
                sum-=nums[a++];
            }
            b++;
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}