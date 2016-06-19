import java.util.*;

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
	public static List<Integer> singleNumberIII(int[] A) {
        // write your code here
		int xor=0;
		for(int i=0;i<A.length;i++)
			xor^=A[i];
		int LSB=xor&(-xor);
		int xor1=0,xor2=0;
		for(int i=0;i<A.length;i++)
			if((A[i]&LSB)==0)
				xor1^=A[i];
			else xor2^=A[i];
		ArrayList<Integer> ans=new ArrayList<Integer>();
		ans.add(xor1);ans.add(xor2);
		return ans;
    }
    public static void main(String[] args){
    	System.out.println(singleNumberIII(new int []{1,2,2,3,4,4,5,3}));
    }
}