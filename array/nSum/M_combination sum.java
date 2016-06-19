package lintcode;
import java.util.*;
// simialr to k sum ii, but no limitation on k !!
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    public void backtrack(int[] candidates, int target, int sum, int index, List<Integer>set){
        if(sum==target) {
            ans.add(new ArrayList(set));
            return;
        }
	if(index==candidates.length) return;
        if(sum>target) return;
        for(int i=index;i<candidates.length;i++){
            // key !! avoid duplicates, combination condition is simpler than permutation
            if(i>index&&candidates[i-1]==candidates[i]) continue;// same level has same number, ignore !!
            set.add(candidates[i]);
            backtrack(candidates,target,sum+candidates[i],i,set);
            set.remove(set.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        Arrays.sort(candidates);// key !! avoid duplicates
        backtrack(candidates,target,0,0,new ArrayList<Integer>());
        return ans;
    }
}