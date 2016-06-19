package lintcode;
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] paths= new int[m][n];
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)return 0;
        paths[0][0]=1;
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        if(i!=0||j!=0)
            paths[i][j]=obstacleGrid[i][j]==1?0:(i>0?paths[i-1][j]:0)+(j>0?paths[i][j-1]:0);
        return paths[m-1][n-1]; 
    }
}