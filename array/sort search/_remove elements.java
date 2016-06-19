public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    // key !! 2 methods, 1. sort color, 2. partition. since remove, can use lazy swap
    public void swap(int[] A, int i, int j){
        int tmp=A[i];
        A[i]=A[j];
        A[j]=tmp;
    }
    public int removeElement(int[] A, int elem) {
        // write your code here
        int cnt=0, i=-1;
        while(++i<A.length)
        if(A[i]!=elem) swap(A,i,cnt++);
        return cnt;
    }
}
