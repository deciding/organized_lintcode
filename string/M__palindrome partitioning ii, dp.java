package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    // !! preprocess, also a method for an O(N^2) longest palindrome
    // half triangle, right diagnols
	public static void preprocess(String s, boolean[][] isPalindrome){
		if(s.length()<2) return;
		for(int i=0;i<s.length();i++)
			isPalindrome[i][i]=true;
		for(int i=0;i<s.length()-1;i++)
			isPalindrome[i][i+1]=s.charAt(i)==s.charAt(i+1);
		for(int i=s.length()-3;i>=0;i--)
			for(int len=2;len+i<s.length();len++)
				isPalindrome[i][i+len]=isPalindrome[i+1][i+len-1]&&s.charAt(i)==s.charAt(i+len);
	}
    public static int minCut(String s) {
        // write your code here
    	// the dp means how many splits before this character, we must have a -1 at first !!
    	//in case the very first boundary split is counted
        // len+1
    	if(s.length()<2) return 0;
    	boolean[][] isPalindrome=new boolean[s.length()][s.length()];
    	preprocess(s,isPalindrome);
    	int[] mem=new int[s.length()+1];
    	mem[0]=-1;
    	for(int i=1;i<mem.length;i++)
    		mem[i]=Integer.MAX_VALUE;
        // key !! for mem[i], the character at i is exclusive. This means how many cuts in [0,i-1]
    	for(int i=0;i<s.length();i++)
    		for(int j=0;j<=i;j++)
    			if(isPalindrome[j][i])
    				mem[i+1]=Math.min(mem[i+1],mem[j]+1);
    	return mem[s.length()];
    }
    public static void main(String[] args){
    	System.out.println(minCut("abcccb"));
    }
};