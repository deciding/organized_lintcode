class Solution {
    //bs for k
    //k/2 can be eliminated for each iteration, 2 cases: whether one of the arr has >=k/2 elems
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public int findKth(int A[],int ai,int B[], int bi, int k){
        if(ai>=A.length) return B[bi+k-1];
        if(bi>=B.length) return A[ai+k-1];
        if(k==1) return Math.min(A[ai],B[bi]);//in case k/2==0
        boolean concateA;
        if(ai+k/2-1>=A.length) concateA=false;
        else if(bi+k/2-1>=B.length) concateA=true;
        else if(A[ai+k/2-1]<B[bi+k/2-1]) concateA=true;
        else concateA=false;
        if(concateA) return findKth(A,ai+k/2,B,bi,k-k/2);
        else return findKth(A,ai,B,bi+k/2,k-k/2);
    }
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int n=A.length+B.length;
        if(n%2==1) return findKth(A,0,B,0,n/2+1);
        return (findKth(A,0,B,0,n/2)+findKth(A,0,B,0,n/2+1))/2.0;
    }
}
