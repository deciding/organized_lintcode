import java.util.*;
// for permutation: 1. recursion-DFS add remove 2.iterative-2 while loops, len and choices, add choices
// for 2^n: 1. recursion- DFS add remove 2. iterative-2 loops , bits 

//!! permutation vs. all combinations
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	//iterative
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
    	Arrays.sort(nums);// !! for increasing order in each combination
    	ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
    	for(int i=0;i<(1<<nums.length);i++){
        	ArrayList<Integer> item= new ArrayList<Integer>();
    		for(int j=0;j<nums.length;j++)
    			if(((1<<j)&i)!=0) item.add(nums[j]);
    		ans.add(item);
    	}
    	return ans;
    }
    //recursive
    public static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> item, int[] nums, int index){
    	ans.add(new ArrayList<Integer>(item));// ALL combinations !!
    	if(index==nums.length) return;// use index in combination but not boolean[] used in permutation !!
    	for(int i=index;i<nums.length;i++){
    		item.add(nums[i]);
    		helper(ans,item,nums,i+1);
    		item.remove(item.size()-1);
    	}
    }
    public static ArrayList<ArrayList<Integer>> subsets_r(int[] nums) {
        // write your code here
    	Arrays.sort(nums);
    	ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> item=new ArrayList<Integer>();
    	helper(ans,item,nums,0);
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(subsets_r(new int[]{1,2,3}));
    }
}