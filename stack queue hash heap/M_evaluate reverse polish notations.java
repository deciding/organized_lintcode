package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        Stack<Integer> st= new Stack<Integer>();
        int a,b;
        for(int i=0;i<tokens.length;i++){
            switch(tokens[i]){
                case "+":
                	a=st.pop();
                    b=st.pop();
                    st.push(b+a);
                    break;
                case "-":
                	a=st.pop();
                    b=st.pop();
                    st.push(b-a);
                    break;
                case "*":
                	a=st.pop();
                    b=st.pop();
                    st.push(b*a);
                    break;
                case "/":
                	a=st.pop();
                    b=st.pop();
                    st.push(b/a);// key !! the order of b/a is important
                    break;
                default:
                    st.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return st.pop();
    }
}