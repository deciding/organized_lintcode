package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public void addParenthesis(ArrayList<String> ans, String str,int l,int r){
        if(l==0&&r==0) ans.add(str);
        if(l>0) addParenthesis(ans,str+"(",l-1,r);// key !! when to add (
        if(r>0&&r>l) addParenthesis(ans,str+")",l,r-1);// key !! when to add ), one more condition r>l
    }
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> ans=new ArrayList<String>();
        addParenthesis(ans,"",n,n);
        return ans;
    }
}