package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    // len+1
    // first col all 1, first row all 0, is the correct base case
    // nums[i][j] = nums[i - 1][j];
    // if (S.charAt(i - 1) == T.charAt(j - 1)) nums[i][j] += nums[i - 1][j - 1];
    public static int numDistinct(String S, String T) {
        // write your code here
        int[][] mem=new int[2][S.length()+1];
        for(int i=0;i<=S.length();i++)
        mem[0][i]=1;
        for(int i=1;i<=T.length();i++)
        for(int j=1;j<=S.length();j++){
        	mem[i%2][j]=(j==1?0:mem[i%2][j-1]);
            if(T.charAt(i-1)==S.charAt(j-1)) mem[i%2][j]+=((j==1&&i!=1)?0:mem[(i-1)%2][j-1]);
        }
        return mem[T.length()%2][S.length()];
    }
    public static void main(String[] args){
    	System.out.println(numDistinct("ddd","dd"));
    }
}