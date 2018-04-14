package lintcode;
import java.util.*;

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */

//    The numbers in adjacent positions are different.
//    A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
// very important info, only then will there must be peak in between, if(A[mid]==A[mid-1]) either left or right is needed to find peak
// we can use the infos to build sub range which must have a peak

	public static int findPeak(int[] A) {
	       int a=1,b=A.length-1;
	       while(a+1<b){
	    	   int mid=(a+b)/2;
	    	   if(A[mid]<A[mid+1]) a=mid+1;
	    	   else if(A[mid]<A[mid-1]) b=mid-1;
	    	   else return mid;
	       }
	       if(A[a]>A[b]) return a;
	       else return b;
	    }
    public static void main(String[] args){
    	System.out.println(findPeak(new int []{1,2,1,3,4,5,7,6}));
    }
}
