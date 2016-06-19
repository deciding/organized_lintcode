package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        HashSet<Character> hs= new HashSet<Character>();
        int l=0;
        int len=0,max=0;
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                int l_prev=l;
                while(s.charAt(l)!=s.charAt(i)){
                    hs.remove(s.charAt(l++));
                }
                len-=(l-l_prev);
                l++;
            }
            else{
            	len++;
                hs.add(s.charAt(i));
                max=Math.max(max,len);
            }
        }
        return max;
    }
}