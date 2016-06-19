public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    // either increasing or decreasing
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        int len=1,ans=0;
        if(A.length==0) return 0;
        if(A.length==1) return 1;
        for(int i=1;i<A.length;i++)
        if(A[i-1]>A[i]){
            len++;
            ans=Math.max(ans,len);
        }
        else len=1;
        len=1;
        for(int i=1;i<A.length;i++)
        if(A[i-1]<A[i]){
            len++;
            ans=Math.max(ans,len);
        }
        else len=1;
        return ans;
    }
}
