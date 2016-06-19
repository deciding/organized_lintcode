import java.util.*;
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public static int maximalRectangle(int[][] matrix, int m, int n) {
        // write your code here
    	int max=0;
    	int[][] h=new int[m+1][n+1],w=new int[m+1][n+1];
    	for(int i=1;i<=m;i++)
    		for(int j=1;j<=n;j++)
    		if(matrix[i-1][j-1]==1){
    			h[i][j]=Math.min(h[i][j-1]!=0?h[i][j-1]:Integer.MAX_VALUE, h[i-1][j]+1);
    			w[i][j]=Math.min(w[i-1][j]!=0?w[i-1][j]:Integer.MAX_VALUE, w[i][j-1]+1);
    			max=Math.max(max, h[i][j]*w[i][j]);
    		}
    	return max;
    }
    public static void main(String[] args){
    	System.out.println(maximalRectangle(new int[][]{
    			{1,1,1,1,1},
    			{1,1,1,1,1},
    			{1,1,1,1,1},
    			{1,1,1,1,1},
    			{0,0,1,1,1}
    	},5,5
    	));
    }
}
