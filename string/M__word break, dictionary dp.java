import java.util.*;

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    // similar to backpack
    public static boolean wordBreak(String s, Set<String> dict) {
    	// write your code here  
        // len+1, similar as palindrome partitioning
    	if(s==null||s.length()==0) return true; 
    	int maxLen = Integer.MIN_VALUE;
    	for(String str:dict)
    		maxLen=Math.max(maxLen, str.length());//in case TLE
    	boolean[] mem=new boolean[s.length()+1];
    	mem[0]=true;
    	for(int i=1;i<s.length()+1;i++)
    		for(int j=i-1;j>=Math.max(0,i-maxLen);j--)//key! TLE , shorter first !
    		    if(mem[j]){//in case TLE
        			String substr=s.substring(j,i);
        			if(dict.contains(substr)){
        				mem[i]=true;
        				break;//in case TLE
        			}
    		    }
    	return mem[s.length()];
    }
    public static void main(String[] args){
    	Set<String> dict= new HashSet<String>();
    	dict.add("lint");
    	dict.add("code");
    	System.out.println(wordBreak("lintcode",dict));
    }
}