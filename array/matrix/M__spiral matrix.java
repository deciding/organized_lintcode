import java.util.*;
public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    // key !! keep shrinking square area by x1,y1,x2,y2, remember the first 2 special cases
    public static List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
    	ArrayList<Integer> ans=new ArrayList<Integer>();
    	if(matrix==null||matrix.length==0||matrix[0].length==0) return ans;
    	int x1=0,x2=matrix[0].length-1;
    	int y1=0,y2=matrix.length-1;
    	while(x1<=x2&&y1<=y2){
    		for(int i=x1;i<=x2;i++)
    			ans.add(matrix[y1][i]);
    		y1++;
    		if(y1>y2) break;//bcoz next next one in implicit
    		for(int i=y1;i<=y2;i++)
    			ans.add(matrix[i][x2]);
    		x2--;
    		if(x1>x2) break;//bcoz next next one in implicit
    		for(int i=x2;i>=x1;i--)
    			ans.add(matrix[y2][i]);
    		y2--;
    		for(int i=y2;i>=y1;i--)
    			ans.add(matrix[i][x1]);
    		x1++;
    	}
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(spiralOrder(new int[][]{
    			{1,2,3},
    			{4,5,6},
    			{7,8,9}
    	}));
    }
}