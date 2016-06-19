package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
	//Manacher's algorithm, O(N), quite similar to KMP
	public static String preprocess(String s){
		String res="^#";
		for(int i=0;i<s.length();i++)
			res=res+s.substring(i,i+1)+"#";
		return res+"$";
	}
    public static String longestPalindrome(String s) {
        // Write your code here
    	if(s=="") return "";
    	String str=preprocess(s);
    	int index=0,len=0,max=0;
    	for(int i=1;i<str.length()-1;i++){
        	len=0;
        	while(str.charAt(i-len-1)==str.charAt(i+len+1))
        	   len++;
        	if(len>max){
        	    max=len;
        	    index=i;
        	}
    	}
    	int L=(index-max)/2,R=(index+max)/2;
    	return s.substring(L,R);
    }
//	
//	public static String preprocess(String s){
//		String res="^#";
//		for(int i=0;i<s.length();i++)
//			res=res+s.substring(i,i+1)+"#";
//		return res+"$";
//	}
//    public static String longestPalindrome(String s) {
//        // Write your code here
//    	if(s=="") return "";
//    	String str=preprocess(s);
//    	int[] P=new int[str.length()];
//    	int C=0,R=0;
//    	for(int i=1;i<str.length()-1;i++){
//    		int i1=C-(i-C);
//    		P[i]=i>R?0:Math.min(P[i1], R-i);
//    		while(str.charAt(P[i]+i+1)==str.charAt(i-P[i]-1))//won't out of bound bcoz of ^$
//    			P[i]++;
//    		if(i+P[i]>R){
//    			R=i+P[i];
//    			C=i;
//    		}
//    	}
//    	int index=0,len=0;
//    	for(int i=0;i<P.length;i++)
//    	if(P[i]>len){
//    		len=P[i];
//    		index=i;
//    	}
//    	int L=(index-len)/2;
//    	R=(index+len)/2;
//    	return s.substring(L,R);
//    }
    public static void main(String[] args){
    	System.out.println(longestPalindrome("aaabbaaa"));
    }
}