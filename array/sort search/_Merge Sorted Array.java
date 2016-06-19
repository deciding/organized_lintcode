// use O(1) space, fill A from back to end
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    // no extra mem: merge from back to end
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int indexA=m-1,indexB=n-1,index=m+n-1;
        while(indexA>=0&&indexB>=0){
            if(B[indexB]>A[indexA]) A[index--]=B[indexB--];
            else A[index--]=A[indexA--];
        }
        if(index>=0){
            while(indexA>=0) A[index--]=A[indexA--];
            while(indexB>=0) A[index--]=B[indexB--];
        }
    }
}
