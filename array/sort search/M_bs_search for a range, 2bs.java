import java.util.*;

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
    	if(A==null||A.length==0) return new int[]{-1,-1};
    	int a=0,b=A.length-1;
    	int left=0,right=0;
    	//search left bound
    	while(a+1<b){
    		int mid=(a+b)/2;
    		if(A[mid]>=target) b=mid;
    		else a=mid;
    	}
    	if(A[a]==target)  left=a;
    	else if(A[b]==target) left=b;
    	else return new int[]{-1,-1};
    	//search right bound
    	a=0;
    	b=A.length-1;
    	while(a+1<b){
    		int mid=(a+b)/2;
    		if(A[mid]>target) b=mid;
    		else a=mid;
    	}
    	if(A[b]==target)  right=b;
    	else if(A[a]==target) right=a;
    	else return new int[]{-1,-1};
    	return new int[]{left,right};
    }
}
