package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    // kCn not all combinations !! use index, permutation use boolean[] used
    ArrayList<List<Integer>> ans= new ArrayList<List<Integer>>();
    public void backtrack(int n, int k, int index, ArrayList<Integer> set){
        if(k==0){
            ans.add(new ArrayList<Integer>(set));
            return;
        }
        if(index==n+1) return;
        for(int i=index;i<=n;i++){
            set.add(i);
            backtrack(n,k-1,i+1,set);
            set.remove(set.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		backtrack(n,k,1,new ArrayList<Integer>());
		return ans;
    }
}