class Solution {
    //similar to permutation, better O(n) valid is to use row, ld, rd
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<String> drawCheckboard(int n, int[] col){
        ArrayList<String> ans=new ArrayList<String>();
        String row;
        for(int i=1;i<n+1;i++){
            row="";
            for(int j=1;j<n+1;j++)
                if(j==col[i]) row+="Q";
                else row+=".";
            ans.add(row);
        }
        return ans;
    }
    boolean valid(int[] col, int row){
        for(int i=1;i<row;i++)
            if(col[i]==col[row]||row-col[row]==i-col[i]||row+col[row]==i+col[i])//don't miss up !!
                return false;
        return true;
    }
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>();
        int[] col=new int[n+2];
        int row=1;
        while(row>0){
            col[row]++;
            if(col[row]==n+1||row==n+1){
                if(row==n+1) ans.add(drawCheckboard(n, col));
                col[row]=0;
                row--;
                continue;
            }
            else if(valid(col,row)) row++;
        }
        return ans;
    }
};