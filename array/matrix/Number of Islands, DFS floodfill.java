//floodfill implicit graph
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    public void floodfill(int i,int j,int m,int n, boolean[][] visited,boolean[][] grid){
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            if(i+dr[k]>=0&&i+dr[k]<m&&j+dc[k]>=0&&j+dc[k]<n&&grid[i][j]&&!visited[i+dr[k]][j+dc[k]])
                floodfill(i+dr[k],j+dc[k],m,n,visited,grid);
        }
    }
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid.length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited =new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)if(grid[i][j]&&!visited[i][j]){
                floodfill(i,j,m,n,visited,grid);
                count++;
            }
        return count;
    }
}
