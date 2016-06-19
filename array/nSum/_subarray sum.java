package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer,Integer> mem= new HashMap<Integer,Integer>();
        int sum=0;
        mem.put(0,-1);// key !! corner case for start from index 0 answer
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(mem.containsKey(sum)){
                ans.add(mem.get(sum)+1);
                ans.add(i);
                return ans;
            }
            mem.put(sum,i);
        }
        return ans;
    }
}