package lintcode;
import java.util.*;
public class Solution {
    //Dp with limited value options 1-100
    //DP when will not use the cells adjacent to it
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if(A.size()<2) return 0;
        int[][] mem=new int[A.size()][101];
        for(int i=0;i<A.size();i++)
        for(int j=1;j<101;j++){
            mem[i][j]=Integer.MAX_VALUE;
            if(i==0) {
                mem[i][j]=Math.abs(j-A.get(0));
                continue;
            }
            for(int k=1;k<101;k++){
                if(Math.abs(k-j)>target) continue;
                mem[i][j]=Math.min(mem[i][j],mem[i-1][k]+Math.abs(j-A.get(i)));
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<101;i++)
        ans=Math.min(ans,mem[mem.length-1][i]);
        return ans;
    }
}