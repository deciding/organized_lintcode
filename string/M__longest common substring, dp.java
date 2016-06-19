package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    //just left diagnols in DP, but here I want to use O(1) memory !!
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        int len=0;
        int max=0;
        for(int i=0;i<A.length();i++){
        len=0;
        for(int j=0;i+j<A.length()&&j<B.length();j++)
        if(A.charAt(i+j)==B.charAt(j)){
            len++;
            max=Math.max(max,len);
        }
        else len=0;
        }
        for(int i=0;i<B.length();i++){
        len=0;
        for(int j=0;i+j<B.length()&&j<A.length();j++)
        if(A.charAt(j)==B.charAt(i+j)){
            len++;
            max=Math.max(max,len);
        }
        else len=0;
        }
        return max;
    }
    public static void main(String[] args){
    	System.out.println(longestCommonSubstring("aaaaa","aaa"));
    }
}