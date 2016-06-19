package lintcode;

// the 2d matrix will become a sorted 1d array if we flattern it

////find the column index, the number equal to target
//start = 0;
//end = column - 1;
//while (start + 1 < end) {
//    int mid = start + (end - start) / 2;
//    if (matrix[row][mid] == target) {
//        return true;
//    } else if (matrix[row][mid] < target) {
//        start = mid;
//    } else {
//        end = mid;
//    }
//}
//if (matrix[row][start] == target) {
//    return true;
//} else if (matrix[row][end] == target) {
//    return true;
//}
//return false;
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    int bstRow(int[][] matrix, int start, int end, int target){
        if(start==end) return start;
        int mid =(start+end)/2+1;// plus one
        if(matrix[mid][0]==target) return mid;
        else if(matrix[mid][0]<target) return bstRow(matrix,mid,end,target);
        else return bstRow(matrix,start,mid-1,target);//minus one
    }
    boolean bstCol(int[] matrix, int start, int end, int target){
        if(start==end) return matrix[start]==target;
        int mid =(start+end)/2+1;
        if(matrix[mid]==target) return true;
        else if(matrix[mid]<target) return bstCol(matrix,mid,end,target);
        else return bstCol(matrix,start,mid-1,target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length==0||matrix[0].length==0) return false;
        int row=bstRow(matrix,0,matrix.length-1,target);
        return bstCol(matrix[row],0,matrix[row].length-1,target);
    }
}
