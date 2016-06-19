package lintcode;
import java.util.*;
// use comparator
public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    
    public static String largestNumber(int[] num) {
    	// write your code here
        String ans="";
        // key !! string compare
        Comparator<String> cmp=new Comparator<String>(){
            public int compare(String a,String b){
                return (b+a).compareTo(a+b);
            }
        };
        String[] strs=new String[num.length];
        for(int i=0;i<strs.length;i++)
        strs[i]=Integer.toString(num[i]);
        Arrays.sort(strs,cmp);
        for(int i=0;i<strs.length;i++)
        ans=ans+strs[i];
        while(ans.length()>1&&ans.charAt(0)=='0')
        ans=ans.substring(1,ans.length());
        return ans;
    }
    public static void main(String[] args){
    	System.out.println(largestNumber(new int[]{0,0}));
    }
}