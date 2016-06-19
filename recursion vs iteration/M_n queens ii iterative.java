class Solution {
    //similar to permutation, better O(n) valid is to use row, ld, rd
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    boolean valid(int[] col, int row){
        for(int i=1;i<row;i++)
            if(col[i]==col[row]||row-col[row]==i-col[i]||row+col[row]==i+col[i])//don't miss up !!
                return false;
        return true;
    }
    public int totalNQueens(int n) {
        // write your code here
        int cnt=0;
        int[] col=new int[n+2];
        int row=1;
        while(row>0){
            col[row]++;
            if(col[row]==n+1||row==n+1){
                if(row==n+1) cnt++;
                col[row]=0;
                row--;
                continue;
            }
            else if(valid(col,row))row++;
        }
        return cnt;
    }
};

