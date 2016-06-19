import java.util.*;
// less the choices, better the time !!!
public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public static int smallestDifference(int[] A, int[] B) {
        // write your code here
    	if(A==null||B==null||A.length==0||B.length==0) return -1;
    	Arrays.sort(A);
    	Arrays.sort(B);
    	int a=0,b=0;
    	int min=Integer.MAX_VALUE;
    	while(a<A.length&&b<B.length){
    		min=Math.min(min, Math.abs(A[a]-B[b]));
    		if(A[a]>B[b])b++;
    		else a++;
    	}
    	return min;
    }
    public static void main(String[] args){
    	System.out.println(smallestDifference(new int[]{3,6,7,4},new int[]{2,8,9,5}));
    }
}
