import java.util.*;
public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public static int[][] generateMatrix(int n) {
        // Write your code here
    	int[][] matrix=new int[n][n];
    	if(n==0) return matrix;
    	int x1=0,x2=n-1;
    	int y1=0,y2=n-1;
    	int num=1;
    	while(x1<=x2&&y1<=y2){
    		for(int i=x1;i<=x2;i++)
    			matrix[y1][i]=num++;
    		y1++;
    		if(y1>y2) break;//bcoz next next one in implicit
    		for(int i=y1;i<=y2;i++)
    			matrix[i][x2]=num++;
    		x2--;
    		if(x1>x2) break;//bcoz next next one in implicit
    		for(int i=x2;i>=x1;i--)
    			matrix[y2][i]=num++;
    		y2--;
    		for(int i=y2;i>=y1;i--)
    			matrix[i][x1]=num++;
    		x1++;
    	}
    	return matrix;
    }
    public static void main(String[] args){
    	System.out.println(Arrays.deepToString(generateMatrix(1)));
    }
}