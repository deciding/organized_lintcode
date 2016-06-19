import java.util.*;
// for four corners, we pick 2 directions, only when wecan only take one correct direction, will it be a 
//"good corner", if we take either two direction it maybe correct, it is not good and not O(m+n)

// no duplicates in row/column, because that will lead to multi-choices when matrix[i][j]==target
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
	public int searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
    	int cnt=0;
    	int i=matrix.length-1;
    	int j=0;
    	while(i>=0&&j<matrix[0].length){
    		if(matrix[i][j]==target) {
    			cnt++;
    			i--;
    			j++;
    		}
    		else if(matrix[i][j]<target) j++;
    		else i--;
    	}
    	return cnt;
    }
}
