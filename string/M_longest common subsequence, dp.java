public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    // same as string alignment, for each i,j in A,B we have 4 operations, match(+1), replace(-inf, don't consider)
    //delete i(0), delete j(0)
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int[][] mem= new int[A.length()+1][B.length()+1];
        for(int i=1;i<A.length()+1;i++)
        for(int j=1;j<B.length()+1;j++){
        mem[i][j]=Math.max(mem[i-1][j],mem[i][j-1]);
        if(A.charAt(i-1)==B.charAt(j-1)) mem[i][j]=Math.max(mem[i][j],mem[i-1][j-1]+1);
        }
        return mem[A.length()][B.length()];
    }
}
