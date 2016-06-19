package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs.length==0) return "";
        String ans="";
        int index=0;
        while(true){
            if(index+1>strs[0].length()) return ans;
            for(int i=1;i<strs.length;i++)
            if(index+1>strs[i].length()||strs[i].charAt(index)!=strs[0].charAt(index))
            return ans;
            ans=ans+strs[0].substring(index,index+1);
            index++;
        }
    }
}