import java.util.*;
//2d->3d, horizontally O(N), vertically O(N^2) cases
public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    // key !! similiar to subarray sum
    public static int[][] submatrixSum(int[][] matrix) {
        // Write your code here
    	int[][] ans= new int[2][2];
    	if(matrix==null||matrix.length==0||matrix[0].length==0) return ans;
    	int m=matrix.length;
    	int n=matrix[0].length;
    	int[][] sum= new int[m+1][n+1];
        // !! preprocess
    	for(int i=0;i<m;i++)
    		for(int j=0;j<n;j++)
    			sum[i+1][j+1]=sum[i][j+1]+sum[i+1][j]-sum[i][j]+matrix[i][j];
    	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    	//vertical O(N^2) cases !!
    	for(int i1=0;i1<m;i1++)
    		for(int i2=i1+1;i2<=m;i2++){
    			hm.clear();
    			//horizontal one pass !! subarray sum
    			for(int j=0;j<=n;j++){
    				int s=sum[i2][j]-sum[i1][j];
    				if(hm.containsKey(s)){
    					int j1=hm.get(s);
    					ans[0][0]=i1;ans[0][1]=j1;
    					ans[1][0]=i2-1;ans[1][1]=j-1;
    					return ans;
    				}
    				else hm.put(s, j);
    			}
    		}
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(Arrays.deepToString(submatrixSum(new int[][]{
    			{1,5,7},
    			{3,7,-8},
    			{4,-8,9}
    	})));
    }
}