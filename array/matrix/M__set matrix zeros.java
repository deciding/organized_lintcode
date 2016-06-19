import java.util.*;
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    // key !! 3 methods
    // 1. O(MN) space, update 0s there, very trivial
    // 2. O(M+N) space, record row, col should be zero or not then update
    // 3. no additional space, use row0, col0 to record should be zero or not
    public void setZeroes(int[][] matrix) {
        // write your code here
    	if(matrix==null||matrix.length==0||matrix[0].length==0) return;
    	int rows=matrix.length,cols=matrix[0].length;
    	boolean row0IsEmpty=false,col0IsEmpty=false;//row0 and col0 are the axis, which will be updated at last
    	for(int i=0;i<cols;i++)
    		if(matrix[0][i]==0){
    			row0IsEmpty=true;
    			break;
    		}
    	for(int i=0;i<rows;i++)
    		if(matrix[i][0]==0){
    			col0IsEmpty=true;
    			break;
    		}
    	for(int i=1;i<rows;i++)
    		for(int j=1;j<cols;j++)
    			if(matrix[i][j]==0) matrix[0][j]=matrix[i][0]=0;
    	for(int i=1;i<rows;i++)
    		for(int j=1;j<cols;j++)
    			if(matrix[0][j]==0||matrix[i][0]==0) matrix[i][j]=0;
    	if(row0IsEmpty)
    		for(int i=0;i<cols;i++)
    			matrix[0][i]=0;
    	if(col0IsEmpty)
    		for(int i=0;i<rows;i++)
    			matrix[i][0]=0;
    }
}