package lintcode;
import java.util.*;
// O(N) time, O(1) space !!
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    // key !! relate index with value
    // O(N) time O(1) space
	public static int firstMissingPositive(int[] A) {
        // write your code here
        for(int i=0;i<A.length;i++)
        // key !! within the range && either one is correct( otherwise infinte loop)
	//A[i]!=A[A[i]] special case of duplicate values
        while(A[i]>0&&A[i]<=A.length&&i+1!=A[i]&&A[i]!=A[A[i]-1]){// !! i+1==A[i] loop itself, A[i]==A[A[i]-1] loop between i A[i]
            int tmp=A[i];
            A[i]=A[tmp-1];
            A[tmp-1]=tmp;
        }
        for(int i=0;i<A.length;i++)
        if(i+1!=A[i]) return i+1;
        return A.length+1;
    }
	public static void main(String[] args){
		firstMissingPositive(new int[]{2,1});
	}
}
