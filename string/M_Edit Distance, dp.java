package lintcode;
import java.util.*;

//mem[i][j] at this time, word1[i]-word2[j] duiqi

//bottom up, len+1
// public int minDistance(String word1, String word2) {
//        int n = word1.length();
//        int m = word2.length();
       
//        int[][] dp = new int[n+1][m+1];
//        for(int i=0; i< m+1; i++)
//            dp[0][i] = i; 
//        for(int i=0; i<n+1; i++)
//            dp[i][0] = i;
       
//        for(int i = 1; i<n+1; i++)
//            for(int j=1; j<m+1; j++)
//                    dp[i][j] = Math.min(dp[i-1][j-1]+(word1.charAt(i-1) == word2.charAt(j-1)?0:1),Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
//        return dp[n][m];
//     }
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int str_align(int[][] mem, String word1, String word2, int m, int n){
        if(m==0) return n;
        if(n==0) return m;
        if(mem[m][n]!=-1) return mem[m][n];
        if(word1.charAt(m-1)==word2.charAt(n-1))// no replacement
        return mem[m][n]=Math.min(Math.min(str_align(mem,word1,word2,m-1,n-1),str_align(mem,word1,word2,m,n-1)+1),str_align(mem,word1,word2,m-1,n)+1);
        else return mem[m][n]=Math.min(Math.min(str_align(mem,word1,word2,m-1,n-1)+1,str_align(mem,word1,word2,m,n-1)+1),str_align(mem,word1,word2,m-1,n)+1);
    }
    public int minDistance(String word1, String word2) {
        // write your code here
        int[][] mem= new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++)
        for(int j=0;j<=word2.length();j++)
        mem[i][j]=-1;
        return str_align(mem,word1,word2,word1.length(),word2.length());
    }
}