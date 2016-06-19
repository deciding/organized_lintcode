package lintcode;
import java.util.*;

// I wanted to use 3 pointers for s1, s2, s3, but what if s1[i1]==s3[i3]&&s2[i2]==s3[i3]
public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] mem= new boolean[s1.length()+1][s2.length()+1];
        mem[0][0]=true;
        for(int i=0;i<s1.length()+1;i++)
        for(int j=0;j<s2.length()+1;j++){
        if(i>0&&s1.charAt(i-1)==s3.charAt(i+j-1)) mem[i][j]|=mem[i-1][j];
        if(j>0&&s1.charAt(j-1)==s3.charAt(i+j-1)) mem[i][j]|=mem[i][j-1];
        }
        return mem[s1.length()][s2.length()];
    }
}