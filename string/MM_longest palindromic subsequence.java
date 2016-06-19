import java.util.*;
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public static int longestPalinfromicSubsequence(String str) {
        // write your code here
    	int max=0;
        int[][] mem= new int[str.length()][str.length()];
        for(int i=0;i<str.length();i++)
        	mem[i][i]=1;
        for(int i=0;i<str.length()-1;i++)
        	mem[i][i+1]=str.charAt(i)==str.charAt(i+1)?2:1;// treat it as a line j=i+1
        for(int i=str.length()-3;i>=0;i--)
        	for(int j=i+2;j<str.length();j++){
        		mem[i][j]=Math.max(str.charAt(i)==str.charAt(j)?2+mem[i+1][j-1]:0, Math.max(mem[i][j-1], mem[i+1][j]));
                //mem[i][j]=Math.max((str.charAt(i)==str.charAt(j)?2:0)+mem[i+1][j-1], Math.max(mem[i][j-1], mem[i+1][j]));
        		//max=Math.max(max, mem[i][j]);
        	}
        return mem[0][str.length()-1];
    }
    public static void main(String[] args){
    	System.out.println(longestPalinfromicSubsequence("racasihaaabh is a car"));
    }
}
