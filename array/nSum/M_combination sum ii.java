package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    public void backtrack(int[] num, int target, int sum, int index, List<Integer>set){
        if(sum==target) {
            ans.add(new ArrayList(set));
            return;
        }
        if(index==num.length) return;
        if(sum>target) return;
        for(int i=index;i<num.length;i++){
            if(i>index&&num[i-1]==num[i]) continue;// key !! avoid duplicates, others same to combination sum
            set.add(num[i]);
            backtrack(num,target,sum+num[i],i+1,set);
            set.remove(set.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        Arrays.sort(num);
        backtrack(num,target,0,0,new ArrayList<Integer>());
        return ans;
    }
}