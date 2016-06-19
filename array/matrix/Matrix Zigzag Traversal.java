public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    // key !! just the right diagnol !!
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        int m=matrix.length;
        int n=matrix[0].length;
        int[] ans = new int[m*n];
        int index=0;
        boolean zig=true;
        for(int sum=0;sum<m+n-1;sum++)
            if(zig){
                for(int i=m-1;i>=0;i--)
                {
                    int j=sum-i;
                    if(j>=0&&j<n) ans[index++]=matrix[i][j];
                }
                zig=!zig;
            }
            else {
                for(int i=0;i<m;i++)
                {
                    int j=sum-i;
                    if(j>=0&&j<n) ans[index++]=matrix[i][j];
                }
                zig=!zig;
            }
        return ans;
    }
}
