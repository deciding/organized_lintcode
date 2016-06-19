//DP
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0];

        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[M - 1][N - 1];
    }
}
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int findMinSum(int i, int j,int[][] grid, int[][] sum, int m, int n){
        if(i==0&&j==0) return sum[0][0]=grid[0][0];
        if(sum[i][j]!=-1) return sum[i][j];
        if(i>0&&j>0)
            return sum[i][j]=grid[i][j]+Math.min(findMinSum(i-1,j,grid,sum,m,n),findMinSum(i,j-1,grid,sum,m,n));
        if(i==0)
            return sum[i][j]=grid[i][j]+findMinSum(i,j-1,grid,sum,m,n);
        else
            return sum[i][j]=grid[i][j]+findMinSum(i-1,j,grid,sum,m,n);
    }
    public int minPathSum(int[][] grid) {
        // write your code here
        int m=grid.length;
        int n=grid[0].length;
        int[][] sum =new int [m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            sum[i][j]=-1;
        return findMinSum(m-1,n-1,grid,sum,m,n);
    }
}

