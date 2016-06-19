package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void percolateDown(int [] A, int i){
        int left=i*2+1;// 1 based: 2i !!
        int right=i*2+2;// 1 based: 2i+1 !!
        int child;
        if(right<A.length&&A[right]<A[i]&&A[right]<A[left]) child=right;
        else if(left<A.length&&A[left]<A[i]) child=left;
        else return;
        int temp=A[i];
        A[i]=A[child];
        A[child]=temp;
        percolateDown(A, child);
    }
    public void heapify(int[] A) {
        // write your code here
        for(int i=A.length/2-1;i>=0;i--)// 1 based: A.length/2 !!
        percolateDown(A,i);
    }
}