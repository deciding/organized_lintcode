package lintcode;
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    //Max.min(mem[i-1][j-1]+triangle[i][j],mem[i-1][j]+triangle[i][j] !!
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int [][] mem= new int[2][triangle.length];
        mem[0][0]=triangle[0][0];
        for(int i=1;i<triangle.length;i++)
        for(int j=0;j<i+1;j++)
        mem[i%2][j]=Math.min(j>0?mem[(i-1)%2][j-1]+triangle[i][j]:Integer.MAX_VALUE,j<i?mem[(i-1)%2][j]+triangle[i][j]:Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<triangle.length;i++)
            ans=Math.min(ans,mem[(triangle.length-1)%2][i]);
        return ans;
    }
}
