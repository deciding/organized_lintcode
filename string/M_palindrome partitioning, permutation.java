package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
    */
    // just permutation
    public boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
    public void insertToResult(List<List<String>> result, ArrayList<String> l, String s){
        if(s.length()==0) {
            result.add((List<String>)l.clone());
            return;
        }
        for(int i=1;i<=s.length();i++){
            String str=s.substring(0,i);
            if(isPalindrome(str)) {
                l.add(str);
                insertToResult(result,l,s.substring(i));
                l.remove(l.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result= new ArrayList<List<String>>();
        ArrayList<String> l= new ArrayList<String>();
        insertToResult(result,l,s);
        return result;
    }
}
