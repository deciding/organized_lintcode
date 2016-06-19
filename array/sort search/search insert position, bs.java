package lintcode;

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
//bst start<x<end, this only break when start=0||end=len-1
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A.length==0) return 0;
        int start=0;
        int end=A.length-1;
        while(start+1<end){
            int mid=(start+end)/2;
            if(A[mid]==target) return mid;
            if(A[mid]<target) start=mid;
            else end=mid;
        }
        //key block !!
        // if(A[start]>target) both are larger than target, so both must be at A[0]
        // if(A[end]<target) both are smaller than target, so both must be at A[len-1]
        if(A[start]>=target) return start;
        if(A[end]<target) return end+1;
        return end;
    }
}
