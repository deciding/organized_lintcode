package lintcode;
import java.util.*;

//if use sum, may cause overflow
public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int x=0;
        for(int i=1;i<=nums.length;i++)
        x^=i;
        for(int i=0;i<nums.length;i++)
        x^=nums[i];
        return x;
    }
}