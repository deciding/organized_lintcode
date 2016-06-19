package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        LinkedList<Character> st= new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '(':case '[':case'{':
                	st.push(s.charAt(i));
                	break;
                case ')':
                	if(st.size()==0) return false;// key !! special case 1
                	if(st.peek()=='(')
                		st.pop();
                	else return false;
                	break;
                case ']':
                	if(st.size()==0) return false;
                	if(st.peek()=='[')
                		st.pop();
                	else return false;
                	break;
                case '}':
                	if(st.size()==0) return false;
                	if(st.peek()=='{')
                		st.pop();
                	else return false;
                	break;
                default:
                	break;
            }
        }
        if(st.size()==0) return true; // key !! special case 2
        else return false;
    }
}