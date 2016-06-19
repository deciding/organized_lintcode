package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    // key !! instead of count how many smaller numbers, we calculate perm for each smaller number(bcoz they may not same)
    // -> use hash set here, in case multi count -> we must use hashmap to count perm, Pn/Pn1*Pn2...-> at last remove calculated
    //bit, that's why we start from MSB this time which is diff from permutation index i

    // !! since we start from MSB, we cannot accumulate fac here
	public long fac(int n){
		long ans=1;
		for(int i=2;i<=n;i++)
			ans*=i;
		return ans;
	}
	// !! Pn/Pn1*Pn2...
	public long permutationWithRepeatedNumbers(HashMap<Integer,Integer> hm){
		long repeater=1;
		int sum=0;
		for(int val:hm.values())
			if(val!=0){
				repeater*=fac(val);//repeat counts
				sum+=val;
			}
		return fac(sum)/repeater;
	}
	// !! hashmap is used for permutationWithRepeatedNumbers
	public void preprocess(HashMap<Integer,Integer> hm, int[] A){
		for(int i=0;i<A.length;i++)
			if(!hm.containsKey(A[i]))
				hm.put(A[i], 1);
			else hm.put(A[i], hm.get(A[i])+1);
	}
    public long permutationIndexII(int[] A) {
        // Write your code here
    	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    	preprocess(hm,A);
    	long ans=0;
    	for(int i=0;i<A.length;i++){
    		HashSet<Integer> smaller=new HashSet<Integer>();// !! make sure each unique number calculate only once
    		for(int j=i+1;j<A.length;j++)
    			if(!smaller.contains(A[j])&&A[j]<A[i]){// !! no duplicates in the same level !!
    				smaller.add(A[j]);
    				hm.put(A[j], hm.get(A[j])-1);
    				ans+=permutationWithRepeatedNumbers(hm);
    				hm.put(A[j], hm.get(A[j])+1);
    			}
    		hm.put(A[i], hm.get(A[i])-1);// !! delete MSB
    	}
    	return ans+1;// 1 based
    }
}