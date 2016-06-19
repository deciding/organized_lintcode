import java.util.*;
public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    // intro !! must use recursion, but not too deep stack !!
	public static ArrayList<Integer> helper(int n){
		if(n==0)return new ArrayList(Arrays.asList(0));
		ArrayList<Integer> ans= helper(n-1);
		ArrayList<Integer> new_ans= new ArrayList<Integer>();
		for(int i=0;i<ans.size();i++)
			for(int j=0;j<10;j++)
				new_ans.add(ans.get(i)*10+j);
		return new_ans;
				
	}
    public static List<Integer> numbersByRecursion(int n) {
        // write your code here
    	ArrayList<Integer> ans=helper(n);
    	return ans.subList(1, ans.size());
    }
    public static void main(String[] args){
    	System.out.println(numbersByRecursion(3));
    }
}
