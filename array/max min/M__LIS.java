import java.util.*;
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
	// public static int longestIncreasingSubsequence(int[] nums) {
 //        int []mem = new int[nums.length];
 //        int max = 0;
 //        for (int i = 0; i < nums.length; i++) {
 //            mem[i] = 1;
 //            for (int j = 0; j < i; j++)
 //                if (nums[j] <= nums[i])
 //                	mem[i] = Math.max(mem[i], mem[j] + 1);
 //            if (mem[i] > max) {
 //                max = mem[i];
 //            }
 //        }
 //        return max;
 //    }
    //if increasing, just use bs for insertion position !!
   public static int binarySearch(ArrayList<Integer> nums, int key){
		if(nums.size()==0) return 0;
		int a=0,b=nums.size()-1;
		while(a+1<b){
			int mid=(a+b)/2;
			if(nums.get(mid)<=key) a=mid;// return the last one
			else b=mid;
		}
		if(nums.get(a)>key) return a;
		if(nums.get(b)<key) return b+1;
		//if we want non-decreasing, firstly we need bs to return last same element, secondly below two lines !!
		if(nums.get(b)==key) return b+1;
		if(nums.get(a)==key) return a+1;
		return b;
	}
	public static int longestIncreasingSubsequence(int[] nums) {
       // write your code here
		ArrayList<Integer> lis=new ArrayList<Integer>();
		for(int i:nums){
			int index=binarySearch(lis, i);
			if(index>=lis.size()) lis.add(i);
			else lis.set(index,i);
		}
		return lis.size();
   }
	public static void main(String[] args){
		System.out.println(longestIncreasingSubsequence(new int[]{1,1,1,1,1,1,1,1}));
		System.out.println(longestIncreasingSubsequence(new int[]{1,3,5,2,2,2,2,3}));
	}
}
