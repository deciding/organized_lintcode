public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        int max=0;
        int m=matrix.length;
        if(m==0) return max;
        int n=matrix[0].length;
        if(n==0) return max;
        int[][] width= new int[m][n];
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        if(matrix[i][j]){
            width[i][j]=1;
            if(j!=0) width[i][j]+=width[i][j-1];
        }
        for(int j=0;j<n;j++){
            Stack<Integer> st= new Stack<>();
            for(int i=0;i<=m;i++){
                int cur=0;
                if(i<m) cur=width[i][j];
                while(!st.isEmpty()&&cur<=width[st.peek()][j]){
                    int w=width[st.pop()][j];
                    int up=-1;
                    if(!st.isEmpty()) up=st.peek();
                    max=Math.max(max,w*(i-up-1));
                }
                st.push(i);
            }
        }
        return max;
    }
}
