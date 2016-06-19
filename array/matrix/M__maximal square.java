package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    // key !! Min(mem[i-1][j],mem[i][j-1],mem[i-1][j-1])+1
    // because e.g. a 3*3 square has 3 adjacent 2*2 squares at those 3 positions !!
    public static int maxSquare(int[][] matrix) {
        // write your code here
    	int ans=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return ans;
        int[][] mem= new int [matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        for(int j=0;j<matrix[0].length;j++)
        if(matrix[i][j]==1){
        mem[i][j]=Math.min(Math.min(i>0?mem[i-1][j]:0,j>0?mem[i][j-1]:0),i>0&&j>0?mem[i-1][j-1]:0)+1;
        ans=Math.max(ans, mem[i][j]*mem[i][j]);
        }
        return ans;
    }
    public static void main(String[] args){
    	System.out.println(maxSquare(new int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,0,0,0,1},{1,0,0,1,0}}));
    }
}