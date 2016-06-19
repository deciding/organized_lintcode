package lintcode;
public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int[][] paths= new int[m][n];
        paths[0][0]=1;
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        if(i!=0||j!=0)
            paths[i][j]=(i>0?paths[i-1][j]:0)+(j>0?paths[i][j-1]:0);
        return paths[m-1][n-1]; 
    }
}
