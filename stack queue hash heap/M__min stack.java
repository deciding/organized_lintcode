package lintcode;
import java.util.*;
//a version easier to understand: every time push in the current min, and every time pop the min stack
public class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        // do initialize if necessary
        st=new Stack<Integer>();
        min=new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        st.push(number);
        if(min.isEmpty()||number<=min.peek()) min.push(number);
    }

    public int pop() {
        // write your code here
        int del=st.pop();
        if(!min.isEmpty()&&min.peek()==del) min.pop();
        return del;
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
