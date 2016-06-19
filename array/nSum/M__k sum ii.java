import java.util.*;
// nearly 2^n(kCn) or n^k?(the another method use n^(k-1))
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
	public static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> record, int[] A, int i, int sum,int k, int target){
		if(sum==target&&k==0) {// key !!
			ans.add(new ArrayList(record));
			return;
		}
		if(k==0||sum>target||i==A.length) return;// key !!
		for(int index=i;index<A.length;index++){
			record.add(A[index]);
			helper(ans,record,A,index+1,sum+A[index],k-1,target);
			record.remove(record.size()-1);
		}
	}
    public static ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    	if(A==null||A.length==0||A.length<k) return ans;
    	if(k==0) return ans;
    	ArrayList<Integer> record= new ArrayList<Integer>();
    	helper(ans,record,A,0,0,k,target);
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(kSumII(new int[]{1,4,6,8,10,13,15,17,18,21,23,26,27,28,29,30,32,35,36},9,133));
    }
}